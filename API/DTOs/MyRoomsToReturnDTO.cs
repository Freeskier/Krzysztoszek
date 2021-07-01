namespace API.DTOs
{
    public class MyRoomsToReturnDTO
    {
        public int RoomID {get; set;}
        public int ReservationID {get; set;}
        public int DoorNum {get; set;}
        public string ImageURL {get; set;}
        public int GuestsCount {get; set;}
        public string DateFrom {get; set;}
        public string DateTo {get; set;}
    }
}