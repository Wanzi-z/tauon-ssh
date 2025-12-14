package tauon.app.ui.containers.session.pages.status.portforwarding;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

import static tauon.app.services.LanguageService.getBundle;

public class PortForwardingTableModel extends AbstractTableModel {
    private final String[] columns = {
            getBundle().getString("app.sites.port_forwarding.label.name"),
            getBundle().getString("app.sites.port_forwarding.label.type"),
            getBundle().getString("app.sites.port_forwarding.label.local_host"),
            getBundle().getString("app.sites.port_forwarding.label.local_port"),
            getBundle().getString("app.sites.port_forwarding.label.remote_host"),
            getBundle().getString("app.sites.port_forwarding.label.remote_port"),
            getBundle().getString("app.sites.port_forwarding.label.enabled"),
            getBundle().getString("app.status_port_forwarding.label.established"),
    };
    private final List<PortForwardingEntry> list = new ArrayList<>();

    public void addEntry(PortForwardingEntry e) {
        list.add(e);
        fireTableDataChanged();
    }

    public void addEntries(List<PortForwardingEntry> entries) {
        if (entries != null) {
            list.addAll(entries);
            fireTableDataChanged();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PortForwardingEntry e = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.name;
            case 1:
                return e.type;
            case 2:
                return e.remoteHost;
            case 3:
                return e.remotePort;
            case 4:
                return e.localHost;
            case 5:
                return e.localPort;
            case 6:
                return e.enabled;
            case 7:
                return e.established;
            default:
                return "";
        }
    }

    public void clear() {
        list.clear();
    }
    
    public void refresh() {
        for (PortForwardingEntry p: list){
            p.refresh();
        }
    }
}
