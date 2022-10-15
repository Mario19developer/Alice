package com.example.alice.BKModelo;

import java.util.Objects;

public class BKAlmacigos {

    //creacion del objeto JSON - se deben generar lo getter and setter
    private String A_Id; // *
    private String B_Categoria; // *
    private String C_Usuario; //
    private String D_Fecha_Registro; // *
    private String E_Fecha_Plantacion; //
    private String F_Zona_Plantacion; // *
    private String G_Rancho_Plantacion; //
    private String H_Codigo_Origen; // *
    private String I_Cultivo; //
    private String J_Cama; //
    private String K_Posicion; // *
    private String L_Lado; // *
    private String M_Ancho_Cama; // *
    private String N_Largo_Cama; // *
    private String O_Variedad_Seleccion; //
    private String P_Clon; //
    private String Q_Prueba; //
    private String R_Producto_Plantado; //
    private String S_Calibre_de_Planta_Plantada; //
    private String T_Libras_Totales_Plantadas; //
    private String U_Promedio_de_Trozos_Plantados; //
    private String V_Total_de_Trozos_Plantados; //
    private String W_Total_Macetas_Plantadas; //
    private String X_Nota_Plantacion; //
    private String Y_Codigo_Almacigos; //
    private String Z_; //

    public void bkalmacigos(String a_Id, String b_Categoria, String c_Usuario, String d_Fecha_Registro,
                            String e_Fecha_Plantacion, String f_Zona_Plantacion, String g_Rancho_Plantacion,
                            String h_Codigo_Origen, String i_Cultivo, String j_Cama, String k_Posicion,
                            String l_Lado, String m_Ancho_Cama, String n_Largo_Cama,
                            String o_Variedad_Seleccion, String p_Clon, String q_Prueba, String r_Producto_Plantado,
                            String s_Calibre_de_Planta_Plantada, String t_Libras_Totales_Plantadas,
                            String u_Promedio_de_Trozos_Plantados, String v_Total_de_Trozos_Plantados,
                            String w_Total_Macetas_Plantadas, String x_Nota_Plantacion, String y_Codigo_Almacigos){


        this.A_Id = a_Id;
        this.B_Categoria = b_Categoria;
        this.C_Usuario = c_Usuario;
        this.D_Fecha_Registro = d_Fecha_Registro;
        this.E_Fecha_Plantacion = e_Fecha_Plantacion;
        this.F_Zona_Plantacion = f_Zona_Plantacion;
        this.G_Rancho_Plantacion = g_Rancho_Plantacion;
        this.H_Codigo_Origen = h_Codigo_Origen;
        this.I_Cultivo = i_Cultivo;
        this.J_Cama = j_Cama;
        this.K_Posicion = k_Posicion;
        this.L_Lado = l_Lado;
        this.M_Ancho_Cama = m_Ancho_Cama;
        this.N_Largo_Cama = n_Largo_Cama;
        this.O_Variedad_Seleccion = o_Variedad_Seleccion;
        this.P_Clon = p_Clon;
        this.Q_Prueba = q_Prueba;
        this.R_Producto_Plantado = r_Producto_Plantado;
        this.S_Calibre_de_Planta_Plantada = s_Calibre_de_Planta_Plantada;
        this.T_Libras_Totales_Plantadas = t_Libras_Totales_Plantadas;
        this.U_Promedio_de_Trozos_Plantados = u_Promedio_de_Trozos_Plantados;
        this.V_Total_de_Trozos_Plantados = v_Total_de_Trozos_Plantados;
        this.W_Total_Macetas_Plantadas = w_Total_Macetas_Plantadas;
        this.X_Nota_Plantacion = x_Nota_Plantacion;
        this.Y_Codigo_Almacigos = y_Codigo_Almacigos;
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

    public String getF_Zona_Plantacion() {
        return F_Zona_Plantacion;
    }

    public void setF_Zona_Plantacion(String f_Zona_Plantacion) {
        F_Zona_Plantacion = f_Zona_Plantacion;
    }

    public String getG_Rancho_Plantacion() {
        return G_Rancho_Plantacion;
    }

    public void setG_Rancho_Plantacion(String g_Rancho_Plantacion) {
        G_Rancho_Plantacion = g_Rancho_Plantacion;
    }

    public String getH_Codigo_Origen() {
        return H_Codigo_Origen;
    }

    public void setH_Codigo_Origen(String h_Codigo_Origen) {
        H_Codigo_Origen = h_Codigo_Origen;
    }

    public String getI_Cultivo() {
        return I_Cultivo;
    }

    public void setI_Cultivo(String i_Cultivo) {
        I_Cultivo = i_Cultivo;
    }

    public String getJ_Cama() {
        return J_Cama;
    }

    public void setJ_Cama(String j_Cama) {
        J_Cama = j_Cama;
    }

    public String getK_Posicion() {
        return K_Posicion;
    }

    public void setK_Posicion(String k_Posicion) {
        K_Posicion = k_Posicion;
    }

    public String getL_Lado() {
        return L_Lado;
    }

    public void setL_Lado(String l_Lado) {
        L_Lado = l_Lado;
    }

    public String getM_Ancho_Cama() {
        return M_Ancho_Cama;
    }

    public void setM_Ancho_Cama(String m_Ancho_Cama) {
        M_Ancho_Cama = m_Ancho_Cama;
    }

    public String getN_Largo_Cama() {
        return N_Largo_Cama;
    }

    public void setN_Largo_Cama(String n_Largo_Cama) {
        N_Largo_Cama = n_Largo_Cama;
    }

    public String getO_Variedad_Seleccion() {
        return O_Variedad_Seleccion;
    }

    public void setO_Variedad_Seleccion(String o_Variedad_Seleccion) {
        O_Variedad_Seleccion = o_Variedad_Seleccion;
    }

    public String getP_Clon() {
        return P_Clon;
    }

    public void setP_Clon(String p_Clon) {
        P_Clon = p_Clon;
    }

    public String getQ_Prueba() {
        return Q_Prueba;
    }

    public void setQ_Prueba(String q_Prueba) {
        Q_Prueba = q_Prueba;
    }

    public String getR_Producto_Plantado() {
        return R_Producto_Plantado;
    }

    public void setR_Producto_Plantado(String r_Producto_Plantado) {
        R_Producto_Plantado = r_Producto_Plantado;
    }

    public String getS_Calibre_de_Planta_Plantada() {
        return S_Calibre_de_Planta_Plantada;
    }

    public void setS_Calibre_de_Planta_Plantada(String s_Calibre_de_Planta_Plantada) {
        S_Calibre_de_Planta_Plantada = s_Calibre_de_Planta_Plantada;
    }

    public String getT_Libras_Totales_Plantadas() {
        return T_Libras_Totales_Plantadas;
    }

    public void setT_Libras_Totales_Plantadas(String t_Libras_Totales_Plantadas) {
        T_Libras_Totales_Plantadas = t_Libras_Totales_Plantadas;
    }

    public String getU_Promedio_de_Trozos_Plantados() {
        return U_Promedio_de_Trozos_Plantados;
    }

    public void setU_Promedio_de_Trozos_Plantados(String u_Promedio_de_Trozos_Plantados) {
        U_Promedio_de_Trozos_Plantados = u_Promedio_de_Trozos_Plantados;
    }

    public String getV_Total_de_Trozos_Plantados() {
        return V_Total_de_Trozos_Plantados;
    }

    public void setV_Total_de_Trozos_Plantados(String v_Total_de_Trozos_Plantados) {
        V_Total_de_Trozos_Plantados = v_Total_de_Trozos_Plantados;
    }

    public String getW_Total_Macetas_Plantadas() {
        return W_Total_Macetas_Plantadas;
    }

    public void setW_Total_Macetas_Plantadas(String w_Total_Macetas_Plantadas) {
        W_Total_Macetas_Plantadas = w_Total_Macetas_Plantadas;
    }

    public String getX_Nota_Plantacion() {
        return X_Nota_Plantacion;
    }

    public void setX_Nota_Plantacion(String x_Nota_Plantacion) {
        X_Nota_Plantacion = x_Nota_Plantacion;
    }

    public String getY_Codigo_Almacigos() {
        return Y_Codigo_Almacigos;
    }

    public void setY_Codigo_Almacigos(String y_Codigo_Almacigos) {
        Y_Codigo_Almacigos = y_Codigo_Almacigos;
    }

    @Override
    public boolean equals(Object obj) {
        return A_Id.equals(((BKAlmacigos)obj).A_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A_Id, B_Categoria, C_Usuario, D_Fecha_Registro, E_Fecha_Plantacion,
                F_Zona_Plantacion, G_Rancho_Plantacion, H_Codigo_Origen, I_Cultivo, J_Cama,
                K_Posicion, L_Lado, M_Ancho_Cama, N_Largo_Cama, O_Variedad_Seleccion, P_Clon,
                Q_Prueba, R_Producto_Plantado, S_Calibre_de_Planta_Plantada,
                T_Libras_Totales_Plantadas, U_Promedio_de_Trozos_Plantados,
                V_Total_de_Trozos_Plantados, W_Total_Macetas_Plantadas, X_Nota_Plantacion,
                Y_Codigo_Almacigos);
    }
}
