using System.Collections.Generic;

namespace API.Models
{
    public class Reservation
    {
        public int ID {get; set;}
        public int UserID {get; set;}
        public int GuestsCount {get; set;}
        public string DateFrom {get; set;}
        public string DateTo {get; set;}
        public User User {get; set;}
        public ICollection<ReservationRoom> ReservationRoom {get; set;}
    }
}