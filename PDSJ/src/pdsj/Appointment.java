/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsj;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author toman
 */
public class Appointment implements Comparable<Appointment>{
    private LocalDate day;
    private LocalTime start;
    private LocalTime end;
    private String description;

    public Appointment(LocalDate day, LocalTime start, LocalTime end, String description) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.day);
        hash = 47 * hash + Objects.hashCode(this.start);
        hash = 47 * hash + Objects.hashCode(this.end);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (other.getEnd().isBefore(this.getEnd()) && other.getEnd().isAfter(this.getStart())){
            return false;
        }
        return !(other.getStart().isBefore(this.getEnd()) && other.getStart().isAfter(this.getStart()));
    }

    @Override
    public String toString() {
        if (Configs.formatDate.equals("common")){
            return "Marcação: " + description + ". " + day.getDayOfWeek() + ", " + day.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + ", desde as " + start + " até às " + end + ".";
        } else {
            return "Marcação: " + description + ". " + day.getDayOfWeek() + ", " + day.format(DateTimeFormatter.ofPattern("yyyy MMMM dd")) + ", desde as " + start + " até às " + end + ".";
        }
    }

    @Override
    public int compareTo(Appointment o) {
        return this.start.compareTo(o.getStart());
    }
}
