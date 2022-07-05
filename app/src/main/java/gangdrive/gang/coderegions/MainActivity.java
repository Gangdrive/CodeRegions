package gangdrive.gang.coderegions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchView searchView;
    CodeRegionsAdapter adapter;
    SearchManager searchManager;
    MenuItem searchItem;
    ArrayList<CodeRegions> codeRegionsList = new ArrayList<CodeRegions>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchViewIcon);
     //   codeRegionsList = new ArrayList<CodeRegions>();

        // начальная инициализация списка
        setInitialData();
        recyclerView = findViewById(R.id.rvCodeRegions);
        // создаем адаптер
        adapter = new CodeRegionsAdapter(this, codeRegionsList);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        searchItem = menu.findItem(R.id.searchViewIcon);
        searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterList(newText);
                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void filterList(String text) {
        List<CodeRegions> filteredList = new ArrayList<>();
        for (CodeRegions codeRegions : codeRegionsList) {
            if (codeRegions.getCode().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(codeRegions);
            } else {
                if (codeRegions.getRegions().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(codeRegions);
                }
            }
        }
        adapter.setFilteredList(filteredList);
    }

    public void setInitialData() {
        codeRegionsList.add(new CodeRegions("01", "Республика Адыгея"));
        codeRegionsList.add(new CodeRegions("02, 102", "Республика Башкортостан"));
        codeRegionsList.add(new CodeRegions("03", "Республика Бурятия"));
        codeRegionsList.add(new CodeRegions("04", "Республика Алтай"));
        codeRegionsList.add(new CodeRegions("05", "Республика Дагестан"));
        codeRegionsList.add(new CodeRegions("06", "Республика Ингушетия"));
        codeRegionsList.add(new CodeRegions("07", "Кабардино-Балкарская республика"));
        codeRegionsList.add(new CodeRegions("08", "Республика Калмыкия"));
        codeRegionsList.add(new CodeRegions("09", "Республика Карачаево-Черкесия"));
        codeRegionsList.add(new CodeRegions("10", "Республика Карелия"));
        codeRegionsList.add(new CodeRegions("11", "Республика Коми"));
        codeRegionsList.add(new CodeRegions("12", "Республика Марий Эл"));
        codeRegionsList.add(new CodeRegions("13, 113", "Республика Мордовия"));
        codeRegionsList.add(new CodeRegions("14", "Республика Саха(Якутия)"));
        codeRegionsList.add(new CodeRegions("15", "Республика Сев.Осетия - Алания"));
        codeRegionsList.add(new CodeRegions("16, 116, 716", "Республика Татарстан"));
        codeRegionsList.add(new CodeRegions("17", "Республика Тыва"));
        codeRegionsList.add(new CodeRegions("18", "Удмуртская республика"));
        codeRegionsList.add(new CodeRegions("19", "Республика Хакасия"));
        codeRegionsList.add(new CodeRegions("21, 121", "Чувашская республика"));
        codeRegionsList.add(new CodeRegions("22, 122", "Алтайский край"));
        codeRegionsList.add(new CodeRegions("23, 93, 123, 193", "Краснодарский край"));
        codeRegionsList.add(new CodeRegions("24, 84, 88, 124", "Красноярский край"));
        codeRegionsList.add(new CodeRegions("25, 125, 725", "Приморский край"));
        codeRegionsList.add(new CodeRegions("26, 126", "Ставропольский край"));
        codeRegionsList.add(new CodeRegions("27", "Хабаровский край"));
        codeRegionsList.add(new CodeRegions("28", "Амурская область"));
        codeRegionsList.add(new CodeRegions("29", "Архангельская область"));
        codeRegionsList.add(new CodeRegions("30", "Астраханская область"));
        codeRegionsList.add(new CodeRegions("31", "Белгородская область"));
        codeRegionsList.add(new CodeRegions("32", "Брянская область"));
        codeRegionsList.add(new CodeRegions("33", "Владимирская область"));
        codeRegionsList.add(new CodeRegions("34, 134", "Волгоградская область"));
        codeRegionsList.add(new CodeRegions("35", "Вологодская область"));
        codeRegionsList.add(new CodeRegions("36, 136", "Воронежская область"));
        codeRegionsList.add(new CodeRegions("37", "Ивановская область"));
        codeRegionsList.add(new CodeRegions("38, 85, 138", "Иркутская область"));
        codeRegionsList.add(new CodeRegions("39, 91", "Калининградская область"));
        codeRegionsList.add(new CodeRegions("40, 140", "Калужская область"));
        codeRegionsList.add(new CodeRegions("41, 82", "Камчатский край"));
        codeRegionsList.add(new CodeRegions("42, 142", "Кемеровская область"));
        codeRegionsList.add(new CodeRegions("43", "Кировская область"));
        codeRegionsList.add(new CodeRegions("44", "Костромская область"));
        codeRegionsList.add(new CodeRegions("45", "Курганская область"));
        codeRegionsList.add(new CodeRegions("46", "Курская область"));
        codeRegionsList.add(new CodeRegions("47, 147", "Ленинградская область"));
        codeRegionsList.add(new CodeRegions("48", "Липецская область"));
        codeRegionsList.add(new CodeRegions("49", "Магаданская область"));
        codeRegionsList.add(new CodeRegions("50, 90, 150, 190, 750, 790", "Московская область"));
        codeRegionsList.add(new CodeRegions("51", "Мурманская область"));
        codeRegionsList.add(new CodeRegions("52, 152", "Нижегородская область"));
        codeRegionsList.add(new CodeRegions("53", "Новгородская область"));
        codeRegionsList.add(new CodeRegions("54, 154", "Новосибирская область"));
        codeRegionsList.add(new CodeRegions("55", "Омская область"));
        codeRegionsList.add(new CodeRegions("56, 156", "Оренбургская область"));
        codeRegionsList.add(new CodeRegions("57", "Орловская область"));
        codeRegionsList.add(new CodeRegions("58", "Пензенская область"));
        codeRegionsList.add(new CodeRegions("59, 81, 159", "Пермский край"));
        codeRegionsList.add(new CodeRegions("60", "Псковская область"));
        codeRegionsList.add(new CodeRegions("61, 161, 761", "Ростовская область"));
        codeRegionsList.add(new CodeRegions("62", "Рязанская область"));
        codeRegionsList.add(new CodeRegions("63, 163, 763", "Самарская область"));
        codeRegionsList.add(new CodeRegions("64, 164", "Саратовская область"));
        codeRegionsList.add(new CodeRegions("65", "Сахалинская область"));
        codeRegionsList.add(new CodeRegions("66, 96, 196", "Свердловская область"));
        codeRegionsList.add(new CodeRegions("67", "Смоленская область"));
        codeRegionsList.add(new CodeRegions("68", "Тамбовская область"));
        codeRegionsList.add(new CodeRegions("69", "Тверская область"));
        codeRegionsList.add(new CodeRegions("70", "Томская область"));
        codeRegionsList.add(new CodeRegions("71", "Тульская область"));
        codeRegionsList.add(new CodeRegions("72, 172", "Тюменская область"));
        codeRegionsList.add(new CodeRegions("73, 173", "Ульяновская область"));
        codeRegionsList.add(new CodeRegions("74, 174, 774", "Челябинская область"));
        codeRegionsList.add(new CodeRegions("75, 80", "Забайкальский край"));
        codeRegionsList.add(new CodeRegions("76", "Ярославская область"));
        codeRegionsList.add(new CodeRegions("77, 97, 99, 177, 199, 777, 797, 799, 977", "Москва"));
        codeRegionsList.add(new CodeRegions("78, 98, 178, 198", "Санкт-Петербург"));
        codeRegionsList.add(new CodeRegions("79", "Еврейская автономная область"));
        codeRegionsList.add(new CodeRegions("82", "Республика Крым"));
        codeRegionsList.add(new CodeRegions("83", "Ненецкий автономный округ"));
        codeRegionsList.add(new CodeRegions("86, 186", "Ханты-Мансийский автономный округ Югра"));
        codeRegionsList.add(new CodeRegions("87", "Чукотский автономный округ"));
        codeRegionsList.add(new CodeRegions("89", "Ямало-Ненецкий автономный округ"));
        codeRegionsList.add(new CodeRegions("92", "Севастополь"));
        codeRegionsList.add(new CodeRegions("94", "Байконур"));
        codeRegionsList.add(new CodeRegions("20, 95", "Чеченская Республика"));

    }
}