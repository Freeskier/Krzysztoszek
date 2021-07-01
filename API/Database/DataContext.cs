using API.Models;
using Microsoft.EntityFrameworkCore;

namespace API.Database
{
    public class DataContext : DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<Reservation> Reservations { get; set; }
        public DbSet<Room> Rooms { get; set; }
        public DataContext(DbContextOptions<DataContext> options) : base (options) {}

        protected override void OnModelCreating(ModelBuilder builder) 
        {
            builder.Entity<ReservationRoom>()
            .HasKey(k => new {k.ReservationID, k.RoomID});

            builder.Entity<ReservationRoom>()
            .HasOne(r => r.Reservation)
            .WithMany(x => x.ReservationRoom)
            .HasForeignKey(r => r.ReservationID)
            .OnDelete(DeleteBehavior.Cascade);

            builder.Entity<ReservationRoom>()
            .HasOne(r => r.Room)
            .WithMany(x => x.ReservationRoom)
            .HasForeignKey(r => r.RoomID)
            .OnDelete(DeleteBehavior.Cascade);

            builder.Entity<Reservation>()
            .HasOne(r => r.User)
            .WithMany(u => u.Reservations)
            .HasForeignKey(r => r.UserID)
            .OnDelete(DeleteBehavior.Cascade);
        }
    }
}