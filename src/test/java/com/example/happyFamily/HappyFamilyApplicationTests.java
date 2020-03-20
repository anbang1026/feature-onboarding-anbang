package com.example.happyFamily;

import com.example.happyFamily.enums.ProductEnum;
import com.example.happyFamily.service.ShopService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HappyFamilyApplication.class)
public class HappyFamilyApplicationTests {

    @Autowired
    private ShopService shopService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testQueryMilkAvailable() {
        //set milk stock first
        shopService.setProductAmount(ProductEnum.MILK.getName(), 500L);
        Long milkStock = shopService.getStockByName(ProductEnum.MILK.getName());
        assert milkStock > 0 : "milk is not available now";
        System.out.println("milk is available now, stock: " + milkStock);
    }

    @Test
    public void testQueryEggAvailable() {
        //set egg stock first
        shopService.setProductAmount(ProductEnum.EGG.getName(), 100L);
        Long eggStock = shopService.getStockByName(ProductEnum.EGG.getName());
        assert eggStock > 0 : "egg is not available now";
        System.out.println("egg is available now, stock: " + eggStock);
    }

/*    @Test
    public void testQueryMilkUnavailable() {
        //set milk stock first
        shopService.setProductAmount(ProductEnum.MILK.getName(), 0L);
        Long milkStock = shopService.getStockByName(ProductEnum.MILK.getName());
        assert milkStock > 0 : "milk is not available now";
        System.out.println("milk is available now, stock: " + milkStock);
    }

    @Test
    public void testQueryEggUnavailable() {
        //set egg stock first
        shopService.setProductAmount(ProductEnum.EGG.getName(), 0L);
        Long eggStock = shopService.getStockByName(ProductEnum.EGG.getName());
        assert eggStock > 0 : "egg is not available now";
        System.out.println("egg is available now, stock: " + eggStock);
    }*/

    @Test
    public void testBuyMilk() {
        //set milk stock first
        shopService.setProductAmount(ProductEnum.MILK.getName(), 20L);
        Long milkStock = shopService.getStockByName(ProductEnum.MILK.getName());
        assert milkStock > 0 : "milk is not available now";
        Long bought = shopService.buyProduct(ProductEnum.MILK.getName(), 10L);
        System.out.printf("bought milk: " + bought);
    }

    @Test
    public void testBuyEgg() {
        //set egg stock first
        shopService.setProductAmount(ProductEnum.EGG.getName(), 10L);
        Long eggStock = shopService.getStockByName(ProductEnum.EGG.getName());
        assert eggStock > 0 : "egg is not available now";
        Long bought = shopService.buyProduct(ProductEnum.EGG.getName(), 12L);
        System.out.printf("bought egg: " + bought);
    }

}
