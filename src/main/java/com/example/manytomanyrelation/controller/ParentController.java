package com.example.manytomanyrelation.controller;

import com.example.manytomanyrelation.dto.ParentDto;
import com.example.manytomanyrelation.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parent")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @PostMapping()
    public ParentDto createParent(@RequestBody ParentDto parentDto) {
        return parentService.addParent(parentDto);
    }

    @PutMapping("/{id}")
    public ParentDto updateParent(@PathVariable(name = "id") Long id, @RequestBody ParentDto parentDto){
        return parentService.updateParent(id, parentDto);
    }
}
