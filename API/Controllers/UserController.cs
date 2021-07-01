using System.Threading.Tasks;
using API.Models;
using API.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [ApiController]
    [Route("api/user/")]
    public class UserController : ControllerBase
    {
        private readonly IUserService userService;

        public UserController(IUserService userService)
        {
            this.userService = userService;
        }

        [HttpPost("register")]
        public async Task<IActionResult> Register([FromBody]User user)
        {
            return Ok(await userService.RegisterAsync(user));
        }


        [HttpPost("login")]
        public async Task <IActionResult> Login([FromBody] User user)
        {
            return Ok(await userService.LoginAsync(user));
        }

        [Authorize]
        [HttpPut("update")]
        public async Task <IActionResult> Update([FromBody] User user)
        {
            return Ok(await userService.UpdateAsync(user));
        }
    }
}