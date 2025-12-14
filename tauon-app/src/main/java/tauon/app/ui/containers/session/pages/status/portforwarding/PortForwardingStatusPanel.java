/**
 *
 */
package tauon.app.ui.containers.session.pages.status.portforwarding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tauon.app.ssh.TauonSSHClient;
import tauon.app.ui.components.misc.SkinnedScrollPane;
import tauon.app.ui.components.page.subpage.Subpage;
import tauon.app.ui.components.simpletable.ConnectionStatusValue;
import tauon.app.ui.components.simpletable.SimpleColumn;
import tauon.app.ui.components.simpletable.SimpleTable;
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
    
    private SimpleTable<PortForwardingEntry> table;
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
        table = new SimpleTable.Builder<PortForwardingEntry>()
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.name"), e -> e.name)
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.type"), e -> e.type)
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.local_host"), e -> e.localHost)
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.local_port"), e -> e.localPort)
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.remote_host"), e -> e.remoteHost)
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.remote_port"), e -> e.remotePort)
                .addColumn(getBundle().getString("app.sites.port_forwarding.label.enabled"), e -> e.enabled)
                .addColumn(getBundle().getString("app.status_port_forwarding.label.established"), ConnectionStatusValue.class, e -> e.status)
                .build();
        add(new SkinnedScrollPane(table));
        
        Box box = Box.createHorizontalBox();
        box.setBorder(new EmptyBorder(10, 0, 0, 0));
        btnRefresh = new JButton(getBundle().getString("general.action.refresh"));
        btnRefresh.addActionListener(e -> table.getEntitiesList().forEach(PortForwardingEntry::refresh));
        
        box.add(Box.createHorizontalGlue());
        box.add(btnRefresh);
        box.add(Box.createHorizontalStrut(5));
        
        add(box, BorderLayout.SOUTH);
        
        for (TauonSSHClient.PortForwardingState p: holder.getSshConnectionHandler().getPortsForwarding()){
            table.getEntitiesList().add(new PortForwardingEntry(p));
        }
        
    }
    
    @Override
    protected void onComponentVisible() {
    
    }
    
    @Override
    protected void onComponentHide() {
    
    }
    
}
