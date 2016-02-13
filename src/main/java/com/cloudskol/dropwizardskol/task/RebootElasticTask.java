package com.cloudskol.dropwizardskol.task;


import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;

import java.io.PrintWriter;

/**
 * @Author tham
 */

public class RebootElasticTask extends Task {
    public RebootElasticTask(String name) {
        super(name);
    }

    @Override
    public void execute(ImmutableMultimap<String, String> immutableMultimap, PrintWriter printWriter) throws Exception {
        System.out.println("Reboot elasic task is triggered");
    }
}
