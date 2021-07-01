using System.Threading.Tasks;
using API.DTOs;
using API.Models;

namespace API.Services
{
    public interface IUserService
    {
        Task<User> RegisterAsync(User user);
        Task<UserToReturnDTO> LoginAsync(User user);
        Task<User> UpdateAsync(User user);
    }
}