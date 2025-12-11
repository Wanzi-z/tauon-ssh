package tauon.app.ui.containers.session.pages.terminal;

import com.jediterm.core.typeahead.TerminalTypeAheadManager;
import com.jediterm.terminal.*;
import com.jediterm.terminal.emulator.JediEmulator;
import com.jediterm.terminal.model.JediTerminal;
import org.jetbrains.annotations.NotNull;

public class CustomTerminalStarter extends TerminalStarter {
    public CustomTerminalStarter(
            @NotNull JediTerminal terminal,
            @NotNull TtyConnector ttyConnector,
            @NotNull TerminalDataStream dataStream,
            @NotNull TerminalTypeAheadManager typeAheadManager,
            @NotNull TerminalExecutorServiceManager executorServiceManager
    ) {
        super(terminal, ttyConnector, dataStream, typeAheadManager, executorServiceManager);
    }
    
    @Override
    protected JediEmulator createEmulator(TerminalDataStream dataStream, Terminal terminal) {
        return new CustomJediEmulator(dataStream, terminal);
    }
}
