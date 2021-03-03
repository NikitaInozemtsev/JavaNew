package ru;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Service {
    List<AllFunc> a = new ArrayList<AllFunc>();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "test.html";
    }

    @RequestMapping(value = "/home/createitem", method = RequestMethod.POST)
    @ResponseBody
    public void createitem(@RequestBody Item w) {
        a.add(w);
    }

    @RequestMapping(value = "/home/createorder", method = RequestMethod.POST)
    @ResponseBody
    public void createorder(@RequestBody Order w) {
        a.add(w);
    }

    @RequestMapping(value = "/home/delete", method = RequestMethod.GET)
    public void del() {
        a = new ArrayList<AllFunc>();
    }

    @RequestMapping(value = "/home/out", method = RequestMethod.GET)
    @ResponseBody
    public List<AllFunc> out() {
        return a;
    }

}
