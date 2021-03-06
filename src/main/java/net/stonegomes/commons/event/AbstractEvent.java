package net.stonegomes.commons.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AbstractEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
