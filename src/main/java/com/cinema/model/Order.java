package com.cinema.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @OneToMany
    @Column(name = "ticket_id")
    private List<Ticket> tickets;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Order(){
    }

    public Order(List<Ticket> tickets, LocalDateTime orderDate, User user) {
        this.tickets = tickets;
        this.orderDate = orderDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order orders = (Order) o;
        return getId().equals(orders.getId())
                && getOrderDate().equals(orders.getOrderDate())
                && getUser().equals(orders.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderDate(), getUser());
    }

    @Override
    public String toString() {
        return "Orders{ order id= " + id
                + ", tickets= " + tickets
                + ", orderDate= " + orderDate
                + ", user=' " + user + " '}";
    }
}
