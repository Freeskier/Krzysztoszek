namespace API.DTOs
{
    public class ReservationToRecieveDTO
    {
        public int UserID {get; set;}
        public int GuestsCount {get; set;}
        public int RoomID {get; set;}
        public string DateFrom {get; set;}
        public string DateTo {get; set;}
    }
}