package exercise.controller;

import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCorses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping(path="/{id}/previous")
    List<Course> getListCourse(@PathVariable long id){
        List<Course> list = new LinkedList<>();
        String path = courseRepository.findById(id).getPath();
        if (path==null)
            return list;
        else if (path.contains(".")){
            String[] strings = path.split("\\.");
            for (int i =0; i<strings.length; i++) {
                long y = Long.parseLong(strings[i]);
                list.add(courseRepository.findById(y));
            }
            return list;
        }
        else {
            list.add(courseRepository.findById(Long.parseLong(path)));
            return list;
        }
    }
    // END

}
