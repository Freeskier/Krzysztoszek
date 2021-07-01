using System.Collections.Generic;

namespace API.Models
{
    public class Room
    {
        public int ID {get; set;}
        public int Capacity {get; set;}
        public int DoorNum {get; set;}
        public string ImageURL {get; set;}
        public float PricePerDay {get; set;}
        public ICollection<ReservationRoom> ReservationRoom {get; set;}
 
    }
}