package com.satish.location.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Packet<T> {
    private boolean status;
    private String message;
    T data;

    public Packet(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
