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
                new MenuItem(2L, "Гиро в лаваше XL", MenuSection.MAIN_MENU, BigDecimal.valueOf(290)));
        menuItemRepo.saveMenuItem(
                new MenuItem(3L, "Гиро в лепёшке", MenuSection.MAIN_MENU, BigDecimal.valueOf(240)));
        menuItemRepo.saveMenuItem(
                new MenuItem(4L, "Гиро в пите", MenuSection.MAIN_MENU, BigDecimal.valueOf(240)));
        menuItemRepo.saveMenuItem(
                new MenuItem(5L, "Люля кебаб на углях в лаваше", MenuSection.MAIN_MENU, BigDecimal.valueOf(330)));
        menuItemRepo.saveMenuItem(
                new MenuItem(6L, "Люля на углях в лепёшке", MenuSection.MAIN_MENU, BigDecimal.valueOf(330)));
        menuItemRepo.saveMenuItem(
                new MenuItem(7L, "Чизбургер куринный", MenuSection.MAIN_MENU, BigDecimal.valueOf(230)));
        menuItemRepo.saveMenuItem(
                new MenuItem(8L, "Хот-Дог", MenuSection.MAIN_MENU, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(9L, "Блэкбургер", MenuSection.MAIN_MENU, BigDecimal.valueOf(230)));

        menuItemRepo.saveMenuItem(
                new MenuItem(10L, "Фри L", MenuSection.SNACKS, BigDecimal.valueOf(130)));
        menuItemRepo.saveMenuItem(
                new MenuItem(11L, "Фри XL", MenuSection.SNACKS, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(12L, "По-деревенски", MenuSection.SNACKS, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(13L, "Наггетсы", MenuSection.SNACKS, BigDecimal.valueOf(150)));
        menuItemRepo.saveMenuItem(
                new MenuItem(14L, "Французкий Хот-Дог", MenuSection.SNACKS, BigDecimal.valueOf(150)));

        menuItemRepo.saveMenuItem(
                new MenuItem(15L, "Халапеньо", MenuSection.SUPPLEMENTS, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(16L, "Сыр", MenuSection.SUPPLEMENTS, BigDecimal.valueOf(40)));

        menuItemRepo.saveMenuItem(
                new MenuItem(17L, "Фирменный от Шефа", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(18L, "Томатный", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(19L, "Барбекю", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(20L, "Сырный", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(21L, "Чесночный", MenuSection.SAUCES, BigDecimal.valueOf(40)));
        menuItemRepo.saveMenuItem(
                new MenuItem(22L, "Кисло-Сладкий", MenuSection.SAUCES, BigDecimal.valueOf(40)));

    }
}
