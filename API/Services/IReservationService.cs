using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using API.DTOs;
using API.Models;

namespace API.Services
{
    public interface IReservationService
    {
        Task<IAsyncResult> AddReservationAsync(ReservationToRecieveDTO reservation);
        Task<IAsyncResult> AddRoomToReservationAsync(int resID, int roomID);
        Task<IAsyncResult> DeleteReservationAsync(Reservation reservation);
        Task<IEnumerable<Reservation>> GetAllReservationsAsync();
        Task<IEnumerable<Reservation>> GetMyReservationsAsync(int ID);
    }
}