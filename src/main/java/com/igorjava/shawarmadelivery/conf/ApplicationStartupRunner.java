package com.igorjava.shawarmadelivery.conf;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.domain.repo.MenuItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final MenuItemRepo menuItemRepo;

    public ApplicationStartupRunner(MenuItemRepo menuItemRepo) {
        this.menuItemRepo = menuItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Гиро в лаваше L", MenuSection.MAIN_MENU, BigDecimal.valueOf(240)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Гиро в лаваше XL", MenuSection.MAIN_MENU, BigDecimal.valueOf(290)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Гиро в лепёшке", MenuSection.MAIN_MENU, BigDecimal.valueOf(240)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Гиро в пите", MenuSection.MAIN_MENU, BigDecimal.valueOf(240)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Люля кебаб на углях в лаваше", MenuSection.MAIN_MENU, BigDecimal.valueOf(330)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Люля на углях в лепёшке", MenuSection.MAIN_MENU, BigDecimal.valueOf(330)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Чизбургер куринный", MenuSection.MAIN_MENU, BigDecimal.valueOf(230)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Хот-Дог", MenuSection.MAIN_MENU, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Блэкбургер", MenuSection.MAIN_MENU, BigDecimal.valueOf(230)));

        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Фри L", MenuSection.SNACKS, BigDecimal.valueOf(130)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Фри XL", MenuSection.SNACKS, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "По-деревенски", MenuSection.SNACKS, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Наггетсы", MenuSection.SNACKS, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Французкий Хот-Дог", MenuSection.SNACKS, BigDecimal.valueOf(150)));

        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Халапеньо", MenuSection.SUPPLEMENTS, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Сыр", MenuSection.SUPPLEMENTS, BigDecimal.valueOf(40)));

        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Фирменный от Шефа", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Томатный", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Барбекю", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Сырный", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Чесночный", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(1L, "Кисло-Сладкий", MenuSection.SAUCES, BigDecimal.valueOf(40)));

    }
}
