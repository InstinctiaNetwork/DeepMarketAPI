package dev.authorises.DeepMarketAPI;

import dev.authorises.DeepMarketAPI.deepmarket.DeepMarketCategory;
import dev.authorises.DeepMarketAPI.deepmarket.DeepMarketItem;
import dev.authorises.DeepMarketAPI.deepmarket.DeepMarketManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepMarketApiApplication {

	public static DeepMarketManager deepMarketManager;

	public static void main(String[] args) {
		deepMarketManager = new DeepMarketManager();

		deepMarketManager.addItem(new DeepMarketItem(
				"TEST_ITEM",
				10D,
				2500D,
				30D,
				DeepMarketCategory.MOB_DROPS,
				"STONE"
		));

		SpringApplication.run(DeepMarketApiApplication.class, args);
	}

}
