using System.Collections.Generic;

namespace API.Models
{
    public class User
    {
        public int ID {get; set;}
        public string Login {get; set;}
        public string Password {get; set;}
        public string Email {get; set;}
        public string FirstName {get; set;}
        public string LastName {get; set;}
        public string Type {get; set;}
        public ICollection<Reservation> Reservations {get; set;}

    }
}