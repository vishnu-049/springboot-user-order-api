package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private List<Note> noteList = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
public Note createNote (@RequestBody Note newNote){
    newNote.setId(nextId++);
    noteList.add(newNote);
    return newNote;
}

@GetMapping("/{id}")
public Note getNoteById(@PathVariable int id){
    return noteList.stream()
    .filter(note -> note.getId()==id)
    .findFirst()
    .orElse(null);
}
@PutMapping("/{id}")
    public Note updateNote(@PathVariable int id, @RequestBody Note updatedNote) {
        for (Note note : noteList) {
            if (note.getId() == id) {
                note.setTitle(updatedNote.getTitle());
                note.setContent(updatedNote.getContent());
                return note;
            }
        }
        return null;
    }
     @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable int id) {
        boolean removed = noteList.removeIf(note -> note.getId() == id);
        return removed ? "Note deleted successfully!" : "Note not found!";
    }

}
