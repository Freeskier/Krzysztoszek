using System;
using System.Linq;
using System.Threading.Tasks;
using API.Authentication;
using API.Database;
using API.DTOs;
using API.Models;
using Microsoft.EntityFrameworkCore;

namespace API.Services
{
    public class UserService : IUserService
    {
        private readonly DataContext context;
        private readonly IJwtAuthenticationManager jwtAuthenticationManager;

        public UserService(DataContext context, IJwtAuthenticationManager jwtAuthenticationManager)
        {
            this.jwtAuthenticationManager = jwtAuthenticationManager;
            this.context = context;
        }

        public async Task<UserToReturnDTO> LoginAsync(User user)
        {
            var usr = await context.Users.FirstOrDefaultAsync(x => x.Login == user.Login && x.Password == user.Password);
            if(usr == null)
                throw new Exception("Given user does not exist!");
            var token = jwtAuthenticationManager.Authenticate(usr.Login, usr.ID);
            return new UserToReturnDTO {
                ID = usr.ID,
                FirstName = usr.FirstName,
                LastName = usr.LastName,
                Login = usr.Login,
                Email = usr.Email,
                Type = usr.Type,
                Token = token
            };
        }

        public async Task<User> RegisterAsync(User user)
        {
            var usr = await context.Users.FirstOrDefaultAsync(x => x.Login == user.Login);
            if(usr != null)
                throw new Exception("User with given login already exists!");
            await context.Users.AddAsync(user);
            await context.SaveChangesAsync();
            var retUser = await context.Users.FirstAsync(x => x.Login == user.Login);
            retUser.Password = "";
            return retUser;
        }

        public async Task<User> UpdateAsync(User user)
        {
            context.Users.Update(user);
            await context.SaveChangesAsync();
            return user;
        }
    }
}