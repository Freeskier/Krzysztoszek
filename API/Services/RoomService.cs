using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using API.Database;
using API.Models;
using Microsoft.EntityFrameworkCore;

namespace API.Services
{
    public class RoomService : IRoomService
    {
        private readonly DataContext context;
        public RoomService(DataContext context)
        {
            this.context = context;
        }

        public async Task<IAsyncResult> AddRoomAsync(Room room)
        {
            await context.AddAsync(room);
            await context.SaveChangesAsync();
            return Task.CompletedTask;
        }

        public async Task<IAsyncResult> DeleteRoomAsync(Room room)
        {
            context.Rooms.Remove(room);
            await context.SaveChangesAsync();
            return Task.CompletedTask;
        }

        public async Task<IEnumerable<Room>> GetAllRoomsAsync()
        {
            return await context.Rooms.ToListAsync();
        }

        public async Task<IEnumerable<Room>> GetMyRoomsAsync(int userID)
        {
            return await context.Reservations.Where(x => x.UserID == userID)
                    .SelectMany(x => x.ReservationRoom.Select(x => x.Room)).ToListAsync();
        }
    }
}