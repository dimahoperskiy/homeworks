package com.server;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("game")
public class ServerController {


    private static ArrayList<User> list = new ArrayList<>();
//    private static long [] move = {-1, -1, -1, -1};
    private static HashMap<String, long[]> moves = new HashMap<>();





    @GetMapping
    public ArrayList<User> get() {
        return list;

    }

    @PostMapping
    public User post(@RequestBody User user) {
//        JSONObject jsonObject = new JSONObject(request);

        list.add(user);
        return user;
    }

    @GetMapping("{gameName}/move")
    public long[] getMove(@PathVariable String gameName) {
        if (!moves.containsKey(gameName))
            moves.put(gameName, new long[] {-1, -1, -1, -1});
        return moves.get(gameName);
    }

    @PostMapping("{gameName}/move")
    public long[] postMove(@RequestBody long[] moveRequest, @PathVariable String gameName) {
        moves.put(gameName, moveRequest);
        return moveRequest;
    }

    @DeleteMapping("{gameName}")
    public void delete(@PathVariable String gameName) {
        list.clear();
        moves.remove(gameName);
    }
}
