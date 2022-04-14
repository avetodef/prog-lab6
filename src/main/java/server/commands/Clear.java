package server.commands;

import common.dao.RouteDAO;
import common.utils.Route;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс команды CLEAR, предназначенный для очистки коллекции
 */
public class Clear extends ACommands{
    static Set<Integer> distanceSet = new HashSet<>();

    public String execute(RouteDAO routeDAO) {

            for (Route route : routeDAO.getAll()) {
                distanceSet.add(route.getDistance());
            }
            for (int i = 1; i < routeDAO.getAll().size() + 1; i++)
                routeDAO.delete(i);
            routeDAO.clear();
            distanceSet.clear();
            return ("коллекция очищена");
    }
}