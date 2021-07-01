using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    public class ReservationRoom
    {
        public Reservation Reservation {get; set;}
        public int ReservationID {get; set;}
        public Room Room {get; set;}
        public int RoomID {get; set;}
    }
}