package net.stonegomes.commons.event;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public class AbstractCancellableEvent extends Event {

    @Getter
    @Setter(AccessLevel.NONE)
    private static final HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    private boolean cancelled = false;

}
