package com.example.alice.GHModelo;

import java.util.Objects;

public class GreenBrotes {

    //se genera la bd despues crear los getter and setter
    private String A_Id; // *
    private String B_Categoria; // Plantación Almacigos, Plantacion Brotes, Trasplante etc
    private String C_Usuario; // *
    private String D_Fecha_Registro; //
    private String E_Fecha_Plantacion; // *
    private String F_Rancho_Plantacion; // *
    private String G_Cultivo; //
    private String H_Orden_Cliente;
    private String I_Proyecto;
    private String J_Lote_Origen;
    private String K_P_Variedad_Seleccion; //
    private String L_Q_Clon; //
    private String M_Sector; // Nave
    private String N_Tunel; // Aguilon
    private String O_Lado; // Lado
    private String P_Cama; // Cama
    private String Q_Producto_Plantado; //
    private String R_Calidad_material; //
    private String S_Numero_Cosecha; //
    private String T_Cavidad_Plantada; //
    private String U_Volumen_Charola; //
    private String V_Charolas_completas_plantadas; //
    private String W_Plantas_por_charola_completa; //
    private String X_Plantas_por_charola_incompletas; //
    private String Y_Total_planta_plantada; //
    private String Z_Total_Planta_mal_plantada; //
    private String ZA_Lote_brotes; //
    private String ZB_Nota; //

    public void greenbrotes(String a_Id, String b_Categoria, String c_Usuario, String d_Fecha_Registro, String e_Fecha_Plantacion, String f_Rancho_Plantacion, String g_Cultivo, String h_Orden_Cliente,
                            String i_Proyecto, String j_Lote_Origen, String k_P_Variedad_Seleccion, String l_Q_Clon, String m_Sector, String n_Tunel, String o_Lado, String p_Cama, String q_Producto_Plantado,
                            String r_Calidad_material, String s_Numero_Cosecha, String t_Cavidad_Plantada, String u_Volumen_Charola, String v_Charolas_completas_plantadas, String w_Plantas_por_charola_completa,
                            String x_Plantas_por_charola_incompletas, String y_Total_planta_plantada, String z_Total_Planta_mal_plantada, String za_Lote_brotes, String zb_Nota){

        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Plantacion = e_Fecha_Plantacion;
        this.F_Rancho_Plantacion = f_Rancho_Plantacion;
        this.G_Cultivo = g_Cultivo;
        this.H_Orden_Cliente = h_Orden_Cliente;
        this.I_Proyecto = i_Proyecto;
        this.J_Lote_Origen = j_Lote_Origen;
        this.K_P_Variedad_Seleccion = k_P_Variedad_Seleccion;
        this.L_Q_Clon = l_Q_Clon;
        this.M_Sector = m_Sector;
        this.N_Tunel = n_Tunel;
        this.O_Lado = o_Lado;
        this.P_Cama = p_Cama;
        this.Q_Producto_Plantado = q_Producto_Plantado;
        this.R_Calidad_material = r_Calidad_material;
        this.S_Numero_Cosecha = s_Numero_Cosecha;
        this.T_Cavidad_Plantada = t_Cavidad_Plantada;
        this.U_Volumen_Charola = u_Volumen_Charola;
        this.V_Charolas_completas_plantadas = v_Charolas_completas_plantadas;
        this.W_Plantas_por_charola_completa = w_Plantas_por_charola_completa;
        this.X_Plantas_por_charola_incompletas = x_Plantas_por_charola_incompletas;
        this.Y_Total_planta_plantada = y_Total_planta_plantada;
        this.Z_Total_Planta_mal_plantada = z_Total_Planta_mal_plantada;
        this.ZA_Lote_brotes = za_Lote_brotes;
        this.ZB_Nota = zb_Nota;
    }


    public String getA_Id() {
        return A_Id;
    }

    public void setA_Id(String a_Id) {
        A_Id = a_Id;
    }

    public String getB_Categoria() {
        return B_Categoria;
    }

    public void setB_Categoria(String b_Categoria) {
        B_Categoria = b_Categoria;
    }

    public String getC_Usuario() {
        return C_Usuario;
    }

    public void setC_Usuario(String c_Usuario) {
        C_Usuario = c_Usuario;
    }

    public String getD_Fecha_Registro() {
        return D_Fecha_Registro;
    }

    public void setD_Fecha_Registro(String d_Fecha_Registro) {
        D_Fecha_Registro = d_Fecha_Registro;
    }

    public String getE_Fecha_Plantacion() {
        return E_Fecha_Plantacion;
    }

    public void setE_Fecha_Plantacion(String e_Fecha_Plantacion) {
        E_Fecha_Plantacion = e_Fecha_Plantacion;
    }

    public String getF_Rancho_Plantacion() {
        return F_Rancho_Plantacion;
    }

    public void setF_Rancho_Plantacion(String f_Rancho_Plantacion) {
        F_Rancho_Plantacion = f_Rancho_Plantacion;
    }

    public String getG_Cultivo() {
        return G_Cultivo;
    }

    public void setG_Cultivo(String g_Cultivo) {
        G_Cultivo = g_Cultivo;
    }

    public String getH_Orden_Cliente() {
        return H_Orden_Cliente;
    }

    public void setH_Orden_Cliente(String h_Orden_Cliente) {
        H_Orden_Cliente = h_Orden_Cliente;
    }

    public String getI_Proyecto() {
        return I_Proyecto;
    }

    public void setI_Proyecto(String i_Proyecto) {
        I_Proyecto = i_Proyecto;
    }

    public String getJ_Lote_Origen() {
        return J_Lote_Origen;
    }

    public void setJ_Lote_Origen(String j_Lote_Origen) {
        J_Lote_Origen = j_Lote_Origen;
    }

    public String getK_P_Variedad_Seleccion() {
        return K_P_Variedad_Seleccion;
    }

    public void setK_P_Variedad_Seleccion(String k_P_Variedad_Seleccion) {
        K_P_Variedad_Seleccion = k_P_Variedad_Seleccion;
    }

    public String getL_Q_Clon() {
        return L_Q_Clon;
    }

    public void setL_Q_Clon(String l_Q_Clon) {
        L_Q_Clon = l_Q_Clon;
    }

    public String getM_Sector() {
        return M_Sector;
    }

    public void setM_Sector(String m_Sector) {
        M_Sector = m_Sector;
    }

    public String getN_Tunel() {
        return N_Tunel;
    }

    public void setN_Tunel(String n_Tunel) {
        N_Tunel = n_Tunel;
    }

    public String getO_Lado() {
        return O_Lado;
    }

    public void setO_Lado(String o_Lado) {
        O_Lado = o_Lado;
    }

    public String getP_Cama() {
        return P_Cama;
    }

    public void setP_Cama(String p_Cama) {
        P_Cama = p_Cama;
    }

    public String getQ_Producto_Plantado() {
        return Q_Producto_Plantado;
    }

    public void setQ_Producto_Plantado(String q_Producto_Plantado) {
        Q_Producto_Plantado = q_Producto_Plantado;
    }

    public String getR_Calidad_material() {
        return R_Calidad_material;
    }

    public void setR_Calidad_material(String r_Calidad_material) {
        R_Calidad_material = r_Calidad_material;
    }

    public String getS_Numero_Cosecha() {
        return S_Numero_Cosecha;
    }

    public void setS_Numero_Cosecha(String s_Numero_Cosecha) {
        S_Numero_Cosecha = s_Numero_Cosecha;
    }

    public String getT_Cavidad_Plantada() {
        return T_Cavidad_Plantada;
    }

    public void setT_Cavidad_Plantada(String t_Cavidad_Plantada) {
        T_Cavidad_Plantada = t_Cavidad_Plantada;
    }

    public String getU_Volumen_Charola() {
        return U_Volumen_Charola;
    }

    public void setU_Volumen_Charola(String u_Volumen_Charola) {
        U_Volumen_Charola = u_Volumen_Charola;
    }

    public String getV_Charolas_completas_plantadas() {
        return V_Charolas_completas_plantadas;
    }

    public void setV_Charolas_completas_plantadas(String v_Charolas_completas_plantadas) {
        V_Charolas_completas_plantadas = v_Charolas_completas_plantadas;
    }

    public String getW_Plantas_por_charola_completa() {
        return W_Plantas_por_charola_completa;
    }

    public void setW_Plantas_por_charola_completa(String w_Plantas_por_charola_completa) {
        W_Plantas_por_charola_completa = w_Plantas_por_charola_completa;
    }

    public String getX_Plantas_por_charola_incompletas() {
        return X_Plantas_por_charola_incompletas;
    }

    public void setX_Plantas_por_charola_incompletas(String x_Plantas_por_charola_incompletas) {
        X_Plantas_por_charola_incompletas = x_Plantas_por_charola_incompletas;
    }

    public String getY_Total_planta_plantada() {
        return Y_Total_planta_plantada;
    }

    public void setY_Total_planta_plantada(String y_Total_planta_plantada) {
        Y_Total_planta_plantada = y_Total_planta_plantada;
    }

    public String getZ_Qty_Planta_mal_plantada() {
        return Z_Total_Planta_mal_plantada;
    }

    public void setZ_Qty_Planta_mal_plantada(String z_Qty_Planta_mal_plantada) {
        Z_Total_Planta_mal_plantada = z_Qty_Planta_mal_plantada;
    }

    public String getZA_Lote_brotes() {
        return ZA_Lote_brotes;
    }

    public void setZA_Lote_brotes(String ZA_Lote_brotes) {
        this.ZA_Lote_brotes = ZA_Lote_brotes;
    }

    public String getZB_Nota() {
        return ZB_Nota;
    }

    public void setZB_Nota(String ZB_Nota) {
        this.ZB_Nota = ZB_Nota;
    }

    @Override
    public boolean equals(Object obj) {
        return A_Id.equals(((GreenBrotes)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro, E_Fecha_Plantacion, F_Rancho_Plantacion, G_Cultivo, H_Orden_Cliente, I_Proyecto, J_Lote_Origen, K_P_Variedad_Seleccion, L_Q_Clon,
                M_Sector, N_Tunel, O_Lado, P_Cama, Q_Producto_Plantado, R_Calidad_material, S_Numero_Cosecha, T_Cavidad_Plantada, U_Volumen_Charola, V_Charolas_completas_plantadas, W_Plantas_por_charola_completa,
                X_Plantas_por_charola_incompletas, Y_Total_planta_plantada, Z_Total_Planta_mal_plantada, ZA_Lote_brotes, ZB_Nota);
    }
}
