using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using API.Models;

namespace API.Services
{
    public interface IRoomService
    {
        Task<IAsyncResult> AddRoomAsync(Room room);
        Task<IAsyncResult> DeleteRoomAsync(Room room);
        Task<IEnumerable<Room>> GetAllRoomsAsync();
        Task<IEnumerable<Room>> GetMyRoomsAsync(int userID);
    }
}