package ru.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.model.Item;
import ru.model.Order;
import ru.services.ItemService;
import ru.services.OrderService;

/**
 * A class that processes operations on a web resource
 */
@Controller
public class MyController {
    /**
     * Service for working with item
     */
    @Autowired
    private ItemService a;

    public MyController(ItemService a, OrderService b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Service for working with order
     */
    @Autowired
    private OrderService b;

    /**
     * Method return first html
     *
     * @return base html
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "test.html";
    }

    /**
     * Method for creating and save in DB item
     *
     * @param w new item
     */
    @RequestMapping(value = "/home/createitem", method = RequestMethod.POST)
    @ResponseBody
    public void createItem(@RequestBody Item w) {
        a.insertItem(w);
    }

    /**
     * Method for creating and save in DB order
     *
     * @param w new order
     */
    @RequestMapping(value = "/home/createorder", method = RequestMethod.POST)
    @ResponseBody
    public void createOrder(@RequestBody Order w) {
        b.insertOrder(w);
    }

    /**
     * Method for deleting item from DB
     *
     * @param w item for delete
     */
    @RequestMapping(value = "/home/deleteitem", method = RequestMethod.POST)
    @ResponseBody
    public void delItem(@RequestBody Item w) {
        a.deleteItem(w);
    }

    /**
     * Method for deleting order from DB
     *
     * @param w order for delete
     */
    @RequestMapping(value = "/home/deleteorder", method = RequestMethod.POST)
    @ResponseBody
    public void delOrder(@RequestBody Order w) {
        b.deleteOrder(w);
    }

    /**
     * Method return all items stored in DB
     *
     * @return list of items
     */
    @RequestMapping(value = "/home/outitem", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> outItem() {
        return new ResponseEntity<List<Item>>(a.getItems(), HttpStatus.OK);
    }

    /**
     * Method return all orders stored in DB
     *
     * @return list of orders
     */
    @RequestMapping(value = "/home/outorder", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> outOrder() {
        return new ResponseEntity<List<Order>>(b.getOrders(), HttpStatus.OK);
    }


}