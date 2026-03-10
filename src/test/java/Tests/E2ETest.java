package Tests;

import Pages.*;
import org.junit.Test;

public class E2ETest extends InitTest {

    @Test
    public void orderTwoProducts() throws InterruptedException {
        PurchaseFlow flow = new PurchaseFlow(browser);

        flow.purchaseTwoProducts("Samsung",
                "Михайло",
                "Дем'янович",
                "0988641210",
                "Рівненська",
                "Рівне",
                "Відділення №37 (до 30 кг на одне місце ): вул. Соборна, 275",
                "Передоплата");

        Thread.sleep(5000);
    }

}
