package org.nibiru.ui.gwt.loop;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.nibiru.ui.core.api.loop.Looper;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

public class SchedulerLooper implements Looper {
	private final Scheduler scheduler;

	@Inject
	public SchedulerLooper(Scheduler scheduler) {
		this.scheduler = checkNotNull(scheduler);
	}

	@Override
	public void post(final Runnable runnable) {
		checkNotNull(runnable);
		scheduler.scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				runnable.run();
			}
		});
	}
}
