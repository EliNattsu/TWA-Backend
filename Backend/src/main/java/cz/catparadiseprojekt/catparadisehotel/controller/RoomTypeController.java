package cz.catparadiseprojekt.catparadisehotel.controller;

import cz.catparadiseprojekt.catparadisehotel.model.RoomType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room-types")
public class RoomTypeController {

    @GetMapping
    public RoomType[] getAllRoomTypes() {
        return RoomType.values();
    }
}