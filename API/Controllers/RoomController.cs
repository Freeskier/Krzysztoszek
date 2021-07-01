using System.Security.Claims;
using System.Threading.Tasks;
using API.Models;
using API.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Authorize]
    [ApiController]
    [Route("api/room/")]
    public class RoomController : ControllerBase
    {
        private readonly IRoomService roomService;

        public RoomController(IRoomService roomService)
        {
            this.roomService = roomService;
        }

        [HttpPost("add")]
        public async Task<IActionResult> AddRoomAsync([FromBody]Room room)
        {
            return Ok(await roomService.AddRoomAsync(room));
        }

        [HttpGet("getAll")]
        public async Task<IActionResult> GetAllRoomsAsync()
        {
            return Ok(await roomService.GetAllRoomsAsync());
        }

        [HttpGet("getMy")]
        public async Task<IActionResult> GetMyRoomsAsync()
        {
            var id = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
            var items = await roomService.GetMyRoomsAsync(id);
            return Ok(items);
        }

        [HttpDelete("delete")]
        public async Task<IActionResult> DeleteRoomAsync([FromBody]Room room)
        {
            return Ok(await roomService.DeleteRoomAsync(room));
        }
    }
}