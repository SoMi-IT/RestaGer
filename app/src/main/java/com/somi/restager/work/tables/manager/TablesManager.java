package com.somi.restager.work.tables.manager;


import com.somi.restager.work.tables.filter.data.TableFilter;
import com.somi.restager.work.tables.data.Table;
import java.util.ArrayList;
import java.util.Collections;


public class TablesManager {


    public static ArrayList<Table> getFakeData(){

        ArrayList<Table> tables = new ArrayList<>();

        Table table1 = new Table();
        table1.setId(5690);
        table1.setNumber(44);
        table1.setInside(true);
        table1.setFree(true);
        table1.setRoom("Sala 1");
        table1.setSeats(2);
        table1.setDescription("Tavolo buono");

        Table table2 = new Table();
        table2.setId(5790);
        table2.setNumber(45);
        table2.setInside(true);
        table2.setFree(true);
        table2.setRoom("Sala 1");
        table2.setSeats(2);
        table2.setDescription("Tavolo buono");

        Table table3 = new Table();
        table3.setId(5697);
        table3.setNumber(46);
        table3.setInside(true);
        table3.setFree(true);
        table3.setRoom("Sala 1");
        table3.setSeats(5);
        table3.setDescription("Tavolo buono");

        Table table4 = new Table();
        table4.setId(5670);
        table4.setNumber(47);
        table4.setInside(true);
        table4.setFree(false);
        table4.setRoom("Sala 1");
        table4.setSeats(5);
        table4.setDescription("Tavolo buono");

        Table table5 = new Table();
        table5.setId(7690);
        table5.setNumber(48);
        table5.setInside(true);
        table5.setFree(true);
        table5.setRoom("Sala 1");
        table5.setSeats(5);
        table5.setDescription("Tavolo buono");

        Table table6 = new Table();
        table6.setId(5091);
        table6.setNumber(45);
        table6.setInside(true);
        table6.setFree(true);
        table6.setRoom("Sala 2");
        table6.setSeats(3);
        table6.setDescription("Tavolo rotto");

        Table table7 = new Table();
        table7.setId(5630);
        table7.setNumber(46);
        table7.setInside(true);
        table7.setFree(false);
        table7.setRoom("Sala 2");
        table7.setSeats(10);
        table7.setDescription("Tavolo buono");



        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        tables.add(table4);
        tables.add(table5);
        tables.add(table6);
        tables.add(table7);

        return tables;

    }//getFakeData


    public static ArrayList<Table> getSortedOrders(ArrayList<Table> tables, int orderType, int sortType) {

        Collections.sort(tables, (obj1, obj2) -> {

            if(orderType == TableFilter.TABLE_TYPE_FILTER_NUMBER && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING) {
                return Integer.compare(obj1.getNumber(), obj2.getNumber());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_NUMBER && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING) {
                return Integer.compare(obj2.getNumber(), obj1.getNumber());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_IS_FREE && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING) {
                return Boolean.compare(obj1.isFree(), obj2.isFree());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_IS_FREE && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING) {
                return Boolean.compare(obj2.isFree(), obj1.isFree());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_IS_INSIDE && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING) {
                return Boolean.compare(obj1.isInside(), obj2.isInside());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_IS_INSIDE && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING) {
                return Boolean.compare(obj2.isInside(), obj1.isInside());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_ROOM && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING) {
                return obj1.getRoom().compareToIgnoreCase(obj2.getRoom());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_ROOM && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING) {
                return obj2.getRoom().compareToIgnoreCase(obj1.getRoom());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_SEATS && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING) {
                return Integer.compare(obj1.getSeats(), obj2.getSeats());

            }else if(orderType == TableFilter.TABLE_TYPE_FILTER_SEATS && sortType == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING) {
                return Integer.compare(obj2.getSeats(), obj1.getSeats());

            }

            // ## Ascending order
            //return obj1.firstName.compareToIgnoreCase(obj2.firstName); // To compare string values
            //return Integer.compare(obj1.getPriority(), obj2.getPriority()); // To compare integer values
            // ## Descending order
            // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
            return Integer.compare(obj1.getNumber(), obj2.getNumber());  // To compare integer values

        });

        return tables;

    }//saveTasks


}//OrdersManager
