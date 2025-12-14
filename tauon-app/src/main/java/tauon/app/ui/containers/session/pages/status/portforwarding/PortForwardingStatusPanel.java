/**
 *
 */
package tauon.app.ui.containers.session.pages.status.portforwarding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tauon.app.ssh.TauonSSHClient;
import tauon.app.ui.components.misc.SkinnedScrollPane;
import tauon.app.ui.components.page.subpage.Subpage;
import tauon.app.ui.containers.session.SessionContentPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static tauon.app.services.LanguageService.getBundle;

/**
 * @author subhro
 */
public class PortForwardingStatusPanel extends Subpage {
    
    private static final Logger LOG = LoggerFactory.getLogger(PortForwardingStatusPanel.class);
    
    private final PortForwardingTableModel model = new PortForwardingTableModel();
    private JTable table;
    private JButton btnRefresh;
    
    /**
     *
     */
    public PortForwardingStatusPanel(SessionContentPanel holder) {
        super(holder);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        
    }
    
    @Override
    protected void createUI() {
        table = new JTable(model);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFillsViewportHeight(true);
        
        table.setAutoCreateRowSorter(true);
        add(new SkinnedScrollPane(table));
        
        Box box = Box.createHorizontalBox();
        box.setBorder(new EmptyBorder(10, 0, 0, 0));
        btnRefresh = new JButton(getBundle().getString("general.action.refresh"));
        btnRefresh.addActionListener(e -> model.refresh());
        
        box.add(Box.createHorizontalGlue());
        box.add(btnRefresh);
        box.add(Box.createHorizontalStrut(5));
        
        add(box, BorderLayout.SOUTH);
        
        for (TauonSSHClient.PortForwardingState p: holder.getSshConnectionHandler().getPortsForwarding()){
            model.addEntry(new PortForwardingEntry(p));
        }
        
        model.refresh();
    }
    
    @Override
    protected void onComponentVisible() {
    
    }
    
    @Override
    protected void onComponentHide() {
    
    }
    
}
