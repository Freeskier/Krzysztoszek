using System.Security.Claims;
using System.Threading.Tasks;
using API.DTOs;
using API.Models;
using API.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [Authorize]
    [ApiController]
    [Route("api/reservation/")]
    public class ReservationController : ControllerBase
    {
        private readonly IReservationService reservationService;

        public ReservationController(IReservationService reservationService)
        {
            this.reservationService = reservationService;
        }

        [HttpPost("add")]
        public async Task<IActionResult> AddReservationAsync([FromBody] ReservationToRecieveDTO reservation)
        {
            return Ok(await reservationService.AddReservationAsync(reservation));
        }

        [HttpGet("getAll")]
        public async Task<IActionResult> GetAllReservationsAsync()
        {
            return Ok(await reservationService.GetAllReservationsAsync());
        }

        [HttpGet("getMy")]
        public async Task<IActionResult> GetMyReservationsAsync()
        {
            var userID = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
            return Ok(await reservationService.GetMyReservationsAsync(userID));
        }

        [HttpDelete("delete")]
        public async Task<IActionResult> DeleteReservationAsync([FromBody] Reservation reservation)
        {
            return Ok(await reservationService.DeleteReservationAsync(reservation));
        }
    }
}