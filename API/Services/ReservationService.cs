using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using API.Database;
using API.DTOs;
using API.Models;
using Microsoft.EntityFrameworkCore;

namespace API.Services
{
    public class ReservationService : IReservationService
    {
        private readonly DataContext context;
        public ReservationService(DataContext context)
        {
            this.context = context;
        }
        public async Task<IAsyncResult> AddReservationAsync(ReservationToRecieveDTO reservation)
        {
            var res = new Reservation()
            {
                UserID = reservation.UserID,
                GuestsCount = reservation.GuestsCount,
                DateFrom = reservation.DateFrom,
                DateTo = reservation.DateTo
            };
            await context.AddAsync(res);
            await context.SaveChangesAsync();
            await AddRoomToReservationAsync(res.ID, reservation.RoomID);
            return Task.CompletedTask;
        }

        public async Task<IAsyncResult> DeleteReservationAsync(Reservation reservation)
        {
            context.Reservations.Remove(reservation);
            await context.SaveChangesAsync();
            return Task.CompletedTask;
        }

        public async Task<IEnumerable<Reservation>> GetAllReservationsAsync()
        {
            return await context.Reservations.ToListAsync();
        }

        public async Task<IEnumerable<Reservation>> GetMyReservationsAsync(int ID)
        {
            return await context.Reservations.Where(x => x.UserID == ID).ToListAsync();
        }

        public async Task<IAsyncResult> AddRoomToReservationAsync(int resID, int roomID)
        {
            var res = new ReservationRoom
            {
                ReservationID = resID,
                RoomID = roomID
            };
            await context.AddAsync<ReservationRoom>(res);
            await context.SaveChangesAsync();
            return Task.CompletedTask;
        }
    }
}