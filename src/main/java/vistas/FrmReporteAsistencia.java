/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import algoritmo.AnalisisAsistenciaCaliente;
import com.personal.utiles.FormularioUtil;
import com.personal.utiles.ReporteUtil;
import controladores.EmpleadoControlador;
import controladores.MarcacionControlador;
import entidades.AsignacionHorario;
import entidades.Marcacion;
import entidades.Turno;
import entidades.escalafon.AreaEmpleado;
import entidades.escalafon.Departamento;
import entidades.escalafon.Empleado;
import entidades.reportes.RptAsistenciaDetallado;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.SwingWorker;
import org.jdesktop.observablecollections.ObservableCollections;
import principal.Main;
import utiles.DetalleReporteAsistenciaComparator;
import utiles.UsuarioActivo;
import vistas.dialogos.DlgEmpleado;
import vistas.dialogos.DlgOficina;
import vistas.modelos.MCFiltro;
import vistas.modelos.MCFiltro.TipoFiltro;
import vistas.modelos.MTDetalleHorarioHR;
import vistas.modelos.MTDetalleRegistroAsistencia;
import vistas.modelos.MTMarcacionRA;
import vistas.renders.RenderIndicadorAsistencia;

/**
 *
 * @author RyuujiMD
 */
public class FrmReporteAsistencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmReporteAsistencia
     */
    public FrmReporteAsistencia() {
        initComponents();
        inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlFechas = new javax.swing.JPanel();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dcFechaFin = new com.toedter.calendar.JDateChooser();
        pnlFiltro = new javax.swing.JPanel();
        cboFiltro = new javax.swing.JComboBox();
        txtBusqueda = new javax.swing.JTextField();
        btnFiltro = new javax.swing.JButton();
        cboTipoAsistencia = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        pbProgreso = new javax.swing.JProgressBar();
        tabReportes = new javax.swing.JTabbedPane();
        pnlDetallado = new javax.swing.JPanel();
        tabDetalles = new javax.swing.JTabbedPane();
        pnlDetalleHorario = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHorario = new org.jdesktop.swingx.JXTable();
        pnlDetalleMarcacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMarcacionesDia = new org.jdesktop.swingx.JXTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new org.jdesktop.swingx.JXTable();
        pnlImprimirSAP = new javax.swing.JPanel();
        btnReportePermisos = new javax.swing.JButton();
        btnImprimirDetalle = new javax.swing.JButton();
        btnReporteVacaciones = new javax.swing.JButton();
        btnReporteHorasExtra = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("REPORTE DE ASISTENCIA");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14))); // NOI18N
        java.awt.GridBagLayout pnlBusquedaLayout = new java.awt.GridBagLayout();
        pnlBusquedaLayout.columnWidths = new int[] {0, 8, 0, 8, 0};
        pnlBusquedaLayout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0};
        pnlBusqueda.setLayout(pnlBusquedaLayout);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Fechas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Filtrar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de asistencia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jLabel3, gridBagConstraints);

        pnlFechas.setLayout(new javax.swing.BoxLayout(pnlFechas, javax.swing.BoxLayout.LINE_AXIS));

        dcFechaInicio.setDateFormatString("dd/MM/yyyy");
        dcFechaInicio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pnlFechas.add(dcFechaInicio);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("-");
        pnlFechas.add(jLabel4);

        dcFechaFin.setDateFormatString("dd/MM/yyyy");
        dcFechaFin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pnlFechas.add(dcFechaFin);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlBusqueda.add(pnlFechas, gridBagConstraints);

        pnlFiltro.setLayout(new java.awt.GridBagLayout());

        cboFiltro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlFiltro.add(cboFiltro, new java.awt.GridBagConstraints());

        txtBusqueda.setEditable(false);
        txtBusqueda.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        pnlFiltro.add(txtBusqueda, gridBagConstraints);

        btnFiltro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnFiltro.setText("...");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });
        pnlFiltro.add(btnFiltro, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlBusqueda.add(pnlFiltro, gridBagConstraints);

        cboTipoAsistencia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cboTipoAsistencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO", "ASISTENCIA REGULAR", "MINUTOS EXTRA AUTORIZADOS", "MINUTOS EXTRA NO AUTORIZADOS", "FALTA INJUSTIFICADA", "PERMISOS CON GOCE", "PERMISOS SIN GOCE", "VACACIONES" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(cboTipoAsistencia, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("Procesar reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlBusqueda.add(pbProgreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(pnlBusqueda, gridBagConstraints);

        tabReportes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        pnlDetallado.setLayout(new java.awt.GridBagLayout());

        tabDetalles.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabDetalles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        pnlDetalleHorario.setLayout(new java.awt.GridBagLayout());

        tblHorario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(tblHorario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlDetalleHorario.add(jScrollPane3, gridBagConstraints);

        tabDetalles.addTab("Detalle del horario", pnlDetalleHorario);

        pnlDetalleMarcacion.setLayout(new java.awt.GridBagLayout());

        tblMarcacionesDia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tblMarcacionesDia);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlDetalleMarcacion.add(jScrollPane2, gridBagConstraints);

        tabDetalles.addTab("Marcaciones en el día", pnlDetalleMarcacion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        pnlDetallado.add(tabDetalles, gridBagConstraints);

        tblDetalle.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tblDetalle.setGridColor(new java.awt.Color(102, 102, 102));
        tblDetalle.setRowHeight(27);
        tblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblDetalleMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalle);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.4;
        pnlDetallado.add(jScrollPane1, gridBagConstraints);

        java.awt.GridBagLayout pnlImprimirSAPLayout = new java.awt.GridBagLayout();
        pnlImprimirSAPLayout.columnWidths = new int[] {0, 8, 0, 8, 0, 8, 0};
        pnlImprimirSAPLayout.rowHeights = new int[] {0};
        pnlImprimirSAP.setLayout(pnlImprimirSAPLayout);

        btnReportePermisos.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnReportePermisos.setText("Reporte de permisos");
        btnReportePermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportePermisosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        pnlImprimirSAP.add(btnReportePermisos, gridBagConstraints);

        btnImprimirDetalle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnImprimirDetalle.setText("Imprimir reporte");
        btnImprimirDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirDetalleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        pnlImprimirSAP.add(btnImprimirDetalle, gridBagConstraints);

        btnReporteVacaciones.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnReporteVacaciones.setText("Reporte de vacaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        pnlImprimirSAP.add(btnReporteVacaciones, gridBagConstraints);

        btnReporteHorasExtra.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnReporteHorasExtra.setText("Reporte de horas extra");
        btnReporteHorasExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteHorasExtraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        pnlImprimirSAP.add(btnReporteHorasExtra, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlDetallado.add(pnlImprimirSAP, gridBagConstraints);

        tabReportes.addTab("Reporte detallado", pnlDetallado);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        jPanel1.add(tabReportes, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private final DateFormat dfFecha = new SimpleDateFormat("dd.MM.yyyy");
    private void btnImprimirDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirDetalleActionPerformed
        // TODO add your handling code here:
        File reporte = new File("reportes/reporte_registro_asistencia_caliente.jasper");
        Map<String, Object> parametros = new HashMap();
        parametros.put("reporte_institucion", Main.REPORTE_INSTITUCION);
        parametros.put("reporte_usuario", UsuarioActivo.getUsuario().getLogin());
        parametros.put("rangoValor", String.format("%s - %s", dfFecha.format(dcFechaInicio.getDate()), dfFecha.format(dcFechaFin.getDate())));
        reporteador.verReporte(this.asistenciaDetalladoList, reporte, parametros, null);
    }//GEN-LAST:event_btnImprimirDetalleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AnalisisAsistenciaWorker worker = new AnalisisAsistenciaWorker();
        worker.execute();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
        MCFiltro.TipoFiltro filtro = (MCFiltro.TipoFiltro) mcFiltro.getSelectedItem();
        switch (filtro) {
            case POR_EMPLEADO:
                DlgEmpleado empleados = new DlgEmpleado(this);
                empleadoSeleccionado = empleados.getSeleccionado();
                txtBusqueda.setText(empleadoSeleccionado == null ? "" : empleadoSeleccionado.getNombreCompleto());
                break;
            case POR_OFICINA:
                DlgOficina oficinas = new DlgOficina(this);
                this.departamentoSeleccionado = oficinas.getSeleccionado();
                txtBusqueda.setText(departamentoSeleccionado == null ? "" : departamentoSeleccionado.getNombre());
                break;
            case POR_GRUPO_HORARIO:
                break;
        }
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnReporteHorasExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteHorasExtraActionPerformed
        // TODO add your handling code here:
        File reporte = new File("reportes/ensa_sap_reporte_horas_extra.jasper");
        Map<String, Object> parametros = new HashMap();
        reporteador.verReporte(filtrar(asistenciaDetalladoList), reporte, parametros, null);
    }//GEN-LAST:event_btnReporteHorasExtraActionPerformed

    private void btnReportePermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportePermisosActionPerformed
        // TODO add your handling code here:
        File reporte = new File("reportes/ensa_sap_reporte_permiso.jasper");
        Map<String, Object> parametros = new HashMap();
        reporteador.verReporte(filtrar(asistenciaDetalladoList), reporte, parametros, null);
    }//GEN-LAST:event_btnReportePermisosActionPerformed

    private void tblDetalleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseReleased
        // TODO add your handling code here:
        int fila = tblDetalle.getSelectedRow();
        if (fila != -1) {
            RptAsistenciaDetallado asistencia = this.asistenciaDetalladoList.get(fila);
            mostrarHorario(asistencia.getAsignacionHorario());
            mostrarMarcacion(asistencia.getEmpleado(), asistencia.getFecha());
        }
    }//GEN-LAST:event_tblDetalleMouseReleased

    private final ReporteUtil reporteador = new ReporteUtil();
    private Empleado empleadoSeleccionado;
    private Departamento departamentoSeleccionado;
    private MCFiltro mcFiltro = new MCFiltro();
    private final AnalisisAsistenciaCaliente analisis = new AnalisisAsistenciaCaliente();
    private List<RptAsistenciaDetallado> asistenciaDetalladoList;
    private List<Turno> turnoList;
    private List<Marcacion> marcacionList;
    private MTDetalleRegistroAsistencia mtdra;
    private final MarcacionControlador marcc = new MarcacionControlador();
    private final EmpleadoControlador empc = new EmpleadoControlador();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnImprimirDetalle;
    private javax.swing.JButton btnReporteHorasExtra;
    private javax.swing.JButton btnReportePermisos;
    private javax.swing.JButton btnReporteVacaciones;
    private javax.swing.JComboBox cboFiltro;
    private javax.swing.JComboBox cboTipoAsistencia;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JProgressBar pbProgreso;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlDetallado;
    private javax.swing.JPanel pnlDetalleHorario;
    private javax.swing.JPanel pnlDetalleMarcacion;
    private javax.swing.JPanel pnlFechas;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JPanel pnlImprimirSAP;
    private javax.swing.JTabbedPane tabDetalles;
    private javax.swing.JTabbedPane tabReportes;
    private org.jdesktop.swingx.JXTable tblDetalle;
    private org.jdesktop.swingx.JXTable tblHorario;
    private org.jdesktop.swingx.JXTable tblMarcacionesDia;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    private final DetalleReporteAsistenciaComparator comparador = new DetalleReporteAsistenciaComparator();

    private void inicializar() {
        //PARA SAN MARCOS
        this.btnReporteHorasExtra.setVisible(false);
        this.btnReportePermisos.setVisible(false);
        this.btnReporteVacaciones.setVisible(false);
        //FIN PARA SAN MARCOS
        this.tblDetalle.setHorizontalScrollEnabled(true);
        this.asistenciaDetalladoList = ObservableCollections.observableList(new ArrayList<RptAsistenciaDetallado>());
        this.turnoList = ObservableCollections.observableList(new ArrayList<Turno>());
        this.marcacionList = ObservableCollections.observableList(new ArrayList<Marcacion>());

        MTDetalleHorarioHR mtTurno = new MTDetalleHorarioHR(turnoList);
        MTMarcacionRA mtMarcacion = new MTMarcacionRA(marcacionList);

        this.mtdra = new MTDetalleRegistroAsistencia(asistenciaDetalladoList);

        this.tblMarcacionesDia.setModel(mtMarcacion);
        this.tblHorario.setModel(mtTurno);
        this.cboFiltro.setModel(mcFiltro);
        this.tblDetalle.setModel(mtdra);
        RenderIndicadorAsistencia render = new RenderIndicadorAsistencia();
        this.tblDetalle.getColumn(0).setCellRenderer(render);
        this.tblDetalle.setDefaultRenderer(Object.class, render);
    }

    private List<RptAsistenciaDetallado> filtrar(List<RptAsistenciaDetallado> listado) {
        List<RptAsistenciaDetallado> filtroList = new ArrayList<>();
//        char tipoAsistencia;
//        tipoAsistencia = tipo.charAt(0);
        for (RptAsistenciaDetallado registro : listado) {
            switch (cboTipoAsistencia.getSelectedIndex()) {
                case 1:
                    if (registro.getTipoDetalle().equals("J") && registro.getTipoAsistencia().equals("R")) {
                        filtroList.add(registro);
                    }
                    break;
                case 2:
                    if (registro.getMinutosExtra() != null) {
                        if (registro.getMinutosExtra() > 0 && registro.isMinutosExtraAutorizado()) {
                            filtroList.add(registro);
                        }
                    }
                    break;
                case 3:
                    if (registro.getMinutosExtra() != null) {
                        if (registro.getMinutosExtra() > 0 && !registro.isMinutosExtraAutorizado()) {
                            filtroList.add(registro);
                        }
                    }

                    break;
                case 4:
                    if (registro.getTipoAsistencia().equals("F")) {
                        filtroList.add(registro);
                    }
                    break;
                case 5:
                    if (registro.getTipoAsistencia().equals("P")) {
                        if (registro.getPermiso().getTipoPermiso().getTipoDescuento() == 'C') {
                            filtroList.add(registro);
                        }
                    }
                    break;
                case 6:
                    if (registro.getTipoAsistencia().equals("P")) {
                        if (registro.getPermiso().getTipoPermiso().getTipoDescuento() == 'S') {
                            filtroList.add(registro);
                        }
                    }
                    break;
                case 7:
                    if (registro.getTipoAsistencia().equals("V")) {
                        filtroList.add(registro);
                    }
                    break;
            }
        }
        return filtroList;
    }

    private void mostrarHorario(AsignacionHorario asignacionHorario) {
        List<Turno> turnos = asignacionHorario.getHorario().getTurnoList();
        turnoList.clear();
        turnoList.addAll(turnos);
        tblHorario.packAll();

    }

    private void mostrarMarcacion(Empleado empleado, Date fecha) {
        List<Marcacion> marcaciones = marcc.buscarXFecha(empleado, fecha);
        marcacionList.clear();
        marcacionList.addAll(marcaciones);
        tblMarcacionesDia.packAll();
    }

    private class AnalisisAsistenciaWorker extends SwingWorker {

        List<RptAsistenciaDetallado> reporte;

        @Override
        protected Object doInBackground() throws Exception {
            FormularioUtil.activarComponente(pnlBusqueda, false);
            pbProgreso.setEnabled(true);
            pbProgreso.setIndeterminate(true);
            pbProgreso.setString("Se está realizando el análisis...");
            pbProgreso.setStringPainted(true);

            List<Empleado> empleadosAnalisis = new ArrayList<>();
            MCFiltro.TipoFiltro filtro = (MCFiltro.TipoFiltro) mcFiltro.getSelectedItem();
            if (filtro == TipoFiltro.TODO) {
                empleadosAnalisis.addAll(empc.buscarXPatron(""));
            } else if (empleadoSeleccionado != null) {
                empleadosAnalisis.add(empleadoSeleccionado);
            } else if (departamentoSeleccionado != null) {
                List<AreaEmpleado> areaEmpleadoList = departamentoSeleccionado.getAreaEmpleadoList();
                for (AreaEmpleado areaEmpleado : areaEmpleadoList) {
                    empleadosAnalisis.add(areaEmpleado.getEmpleado());
                }
            }
            asistenciaDetalladoList.clear();
            if (!empleadosAnalisis.isEmpty()) {
                reporte = analisis.iniciarAnalisis(dcFechaInicio.getDate(), dcFechaFin.getDate(), empleadosAnalisis);
                System.out.println("REPORTE TAMANIO AL GENERAR: " + reporte.size());

            }

            return null;
        }

        @Override
        protected void done() {
            if (!reporte.isEmpty()) {
                if (cboTipoAsistencia.getSelectedIndex() > 0) {
                    reporte = filtrar(reporte);
                    System.out.println("REPORTE TAMANIO DESPUES DE FILTRAR: " + reporte.size());
                }

                Collections.sort(reporte, comparador);
                System.out.println("REPORTE TAMANIO ANTES DE AÑADIR A LA LISTA: " + reporte.size());
                asistenciaDetalladoList.addAll(reporte);
                tblDetalle.packAll();
            } else {
                System.out.println("REPORTE VACÍO");
            }

            pbProgreso.setIndeterminate(false);
            FormularioUtil.activarComponente(pnlBusqueda, true);
            pbProgreso.setString("Análisis completado");
        }

    }
}
