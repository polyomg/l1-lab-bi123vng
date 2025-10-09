package com.example.lab5.service;



import com.example.lab5.model.Item;
import com.example.lab5.util.DB;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.*;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) { // chưa có thì thêm mới
            item = DB.items.get(id);
            item.setQty(1);
            map.put(id, item);
        } else { // có rồi thì tăng số lượng
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(Item::getQty)
                .sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQty())
                .sum();
    }
}
