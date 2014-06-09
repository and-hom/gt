package ru.ahomyakov.gt;

import org.apache.commons.cli.*;
import ru.ahomyakov.gt.impl.*;

public class Cli {

    private Option msgOpt;

    public static void main(String[] args) throws ParseException {
        new Cli().run(args);
    }

    private Options createOptions() {
        Options options = new Options();
        msgOpt = opt("m", "message", true, true, true, "Message to print");
        options.addOption(msgOpt);
        return options;
    }

    private Option opt(String shortName,
                       String longName,
                       boolean required,
                       boolean hasArg,
                       boolean argRequired,
                       String desc) {
        Option opt = new Option(shortName, desc);
        opt.setLongOpt(longName);
        opt.setRequired(true);
        if (hasArg) {
            opt.setArgs(1);
        }
        opt.setOptionalArg(false);
        return opt;
    }

    public void run(String[] args) throws ParseException {
        CommandLine cmd = initCmd(args);
        GtTestCore core = new DummyGtTestCore();

        if (cmd.hasOption(msgOpt.getOpt())) {
            String value = cmd.getOptionValue(msgOpt.getOpt(), null);
            String newValue = core.process(value);
            System.out.println(newValue);
        }
    }

    private CommandLine initCmd(String[] args) throws ParseException {
        Options options = createOptions();
        CommandLineParser parser = new BasicParser();
        return parser.parse(options, args);
    }
}
