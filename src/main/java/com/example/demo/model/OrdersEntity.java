package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;
@Data
@Entity
@Table(name = "Orders", schema = "public", catalog = "bdi")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderNo")
    private String orderNo;
    @Basic
    @Column(name = "total")
    private Double total;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "confirmationStatus")
    private String confirmationStatus;
    @Basic
    @Column(name = "createdBy")
    private String createdBy;
    @Basic
    @Column(name = "creationDate")
    private Object creationDate;
    @Basic
    @Column(name = "customerName")
    private String customerName;
    @Basic
    @Column(name = "customerPhone")
    private String customerPhone;
    @Basic
    @Column(name = "customerEmail")
    private String customerEmail;
    @Basic
    @Column(name = "customerId")
    private String customerId;
    @Basic
    @Column(name = "customerNo")
    private String customerNo;
    @Basic
    @Column(name = "lastModified")
    private Object lastModified;
    @Basic
    @Column(name = "paymentOrderStatus")
    private String paymentOrderStatus;
    @Basic
    @Column(name = "paymentStatus")
    private String paymentStatus;
    @Basic
    @Column(name = "shippingStatus")
    private String shippingStatus;
    @Basic
    @Column(name = "siteId")
    private String siteId;
    @Basic
    @Column(name = "paymentAmount")
    private Double paymentAmount;
    @Basic
    @Column(name = "shipmentType")
    private String shipmentType;
    @Basic
    @Column(name = "shipmentCity")
    private String shipmentCity;
    @Basic
    @Column(name = "shipmentState")
    private String shipmentState;
    @Basic
    @Column(name = "shipmentAddress")
    private String shipmentAddress;
    @Basic
    @Column(name = "shipmentAddress2")
    private String shipmentAddress2;
    @Basic
    @Column(name = "shipmentMethodId")
    private String shipmentMethodId;
    @Basic
    @Column(name = "shippingTotal")
    private Double shippingTotal;
    @Basic
    @Column(name = "productTotal")
    private Double productTotal;
    @Basic
    @Column(name = "productQuantity")
    private Integer productQuantity;
    @Basic
    @Column(name = "statusRayo")
    private String statusRayo;
    @Basic
    @Column(name = "statusFlujo")
    private String statusFlujo;
    @Basic
    @Column(name = "shipmentDeliveryMessage")
    private String shipmentDeliveryMessage;
    @Basic
    @Column(name = "createdAt")
    private Object createdAt;
    @Basic
    @Column(name = "updatedAt")
    private Object updatedAt;
    @Basic
    @Column(name = "local")
    private String local;
    @Basic
    @Column(name = "customerCI")
    private String customerCi;
    @Basic
    @Column(name = "shippingTotalTax")
    private Double shippingTotalTax;
    @Basic
    @Column(name = "totalTax")
    private Double totalTax;
    @Basic
    @Column(name = "statusInvoice")
    private String statusInvoice;
    @Basic
    @Column(name = "statusPick")
    private String statusPick;
    @Basic
    @Column(name = "companyId")
    private int companyId;
    @Basic
    @Column(name = "startPickingDate")
    private Object startPickingDate;
    @Basic
    @Column(name = "endPickingDate")
    private Object endPickingDate;
    @Basic
    @Column(name = "creationDateTimePDA")
    private Object creationDateTimePda;
    @Basic
    @Column(name = "rejectedReason")
    private String rejectedReason;
    @Basic
    @Column(name = "rejectedVendorId")
    private String rejectedVendorId;
    @Basic
    @Column(name = "rejectedDate")
    private Object rejectedDate;
    @Basic
    @Column(name = "uen")
    private String uen;
    @Basic
    @Column(name = "hasPrescription")
    private Boolean hasPrescription;
    @Basic
    @Column(name = "carrier")
    private String carrier;
    @Basic
    @Column(name = "logged")
    private String logged;
    @Basic
    @Column(name = "localPick")
    private String localPick;
    @Basic
    @Column(name = "statusOMS")
    private String statusOms;
    @Basic
    @Column(name = "omsRetry")
    private Integer omsRetry;
    @Basic
    @Column(name = "exportStatus")
    private String exportStatus;
    @Basic
    @Column(name = "folioNo")
    private String folioNo;
    @Basic
    @Column(name = "isValidFolio")
    private Boolean isValidFolio;
    @Basic
    @Column(name = "canalVenta")
    private String canalVenta;
    @Basic
    @Column(name = "idCallCenterTiendaBase")
    private String idCallCenterTiendaBase;
    @Basic
    @Column(name = "idCallCenterPedido")
    private String idCallCenterPedido;
    @Basic
    @Column(name = "folioPedidoPospcCallCenter")
    private String folioPedidoPospcCallCenter;
    @Basic
    @Column(name = "horaSalida")
    private Time horaSalida;
    @Basic
    @Column(name = "horaRegreso")
    private Time horaRegreso;
    @Basic
    @Column(name = "statusPospc")
    private String statusPospc;
    @Basic
    @Column(name = "folioPospc")
    private String folioPospc;
    @Basic
    @Column(name = "tiempoOperativo")
    private Long tiempoOperativo;
    @Basic
    @Column(name = "freeShippingPromotionId")
    private String freeShippingPromotionId;
    @Basic
    @Column(name = "freeShippingCampaignId")
    private String freeShippingCampaignId;
    @Basic
    @Column(name = "promotionId")
    private String promotionId;
    @Basic
    @Column(name = "attributId61")
    private String attributId61;
    @Basic
    @Column(name = "customAttribute60")
    private String customAttribute60;
    @Basic
    @Column(name = "creationDateSfcc")
    private Timestamp creationDateSfcc;
    @Basic
    @Column(name = "paymentType")
    private String paymentType;
    @Basic
    @Column(name = "idCallCenter")
    private String idCallCenter;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return companyId == that.companyId && Objects.equals(orderNo, that.orderNo) && Objects.equals(total, that.total) && Objects.equals(status, that.status) && Objects.equals(confirmationStatus, that.confirmationStatus) && Objects.equals(createdBy, that.createdBy) && Objects.equals(creationDate, that.creationDate) && Objects.equals(customerName, that.customerName) && Objects.equals(customerPhone, that.customerPhone) && Objects.equals(customerEmail, that.customerEmail) && Objects.equals(customerId, that.customerId) && Objects.equals(customerNo, that.customerNo) && Objects.equals(lastModified, that.lastModified) && Objects.equals(paymentOrderStatus, that.paymentOrderStatus) && Objects.equals(paymentStatus, that.paymentStatus) && Objects.equals(shippingStatus, that.shippingStatus) && Objects.equals(siteId, that.siteId) && Objects.equals(paymentAmount, that.paymentAmount) && Objects.equals(shipmentType, that.shipmentType) && Objects.equals(shipmentCity, that.shipmentCity) && Objects.equals(shipmentState, that.shipmentState) && Objects.equals(shipmentAddress, that.shipmentAddress) && Objects.equals(shipmentAddress2, that.shipmentAddress2) && Objects.equals(shipmentMethodId, that.shipmentMethodId) && Objects.equals(shippingTotal, that.shippingTotal) && Objects.equals(productTotal, that.productTotal) && Objects.equals(productQuantity, that.productQuantity) && Objects.equals(statusRayo, that.statusRayo) && Objects.equals(statusFlujo, that.statusFlujo) && Objects.equals(shipmentDeliveryMessage, that.shipmentDeliveryMessage) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(local, that.local) && Objects.equals(customerCi, that.customerCi) && Objects.equals(shippingTotalTax, that.shippingTotalTax) && Objects.equals(totalTax, that.totalTax) && Objects.equals(statusInvoice, that.statusInvoice) && Objects.equals(statusPick, that.statusPick) && Objects.equals(startPickingDate, that.startPickingDate) && Objects.equals(endPickingDate, that.endPickingDate) && Objects.equals(creationDateTimePda, that.creationDateTimePda) && Objects.equals(rejectedReason, that.rejectedReason) && Objects.equals(rejectedVendorId, that.rejectedVendorId) && Objects.equals(rejectedDate, that.rejectedDate) && Objects.equals(uen, that.uen) && Objects.equals(hasPrescription, that.hasPrescription) && Objects.equals(carrier, that.carrier) && Objects.equals(logged, that.logged) && Objects.equals(localPick, that.localPick) && Objects.equals(statusOms, that.statusOms) && Objects.equals(omsRetry, that.omsRetry) && Objects.equals(exportStatus, that.exportStatus) && Objects.equals(folioNo, that.folioNo) && Objects.equals(isValidFolio, that.isValidFolio) && Objects.equals(canalVenta, that.canalVenta) && Objects.equals(idCallCenterTiendaBase, that.idCallCenterTiendaBase) && Objects.equals(idCallCenterPedido, that.idCallCenterPedido) && Objects.equals(folioPedidoPospcCallCenter, that.folioPedidoPospcCallCenter) && Objects.equals(horaSalida, that.horaSalida) && Objects.equals(horaRegreso, that.horaRegreso) && Objects.equals(statusPospc, that.statusPospc) && Objects.equals(folioPospc, that.folioPospc) && Objects.equals(tiempoOperativo, that.tiempoOperativo) && Objects.equals(freeShippingPromotionId, that.freeShippingPromotionId) && Objects.equals(freeShippingCampaignId, that.freeShippingCampaignId) && Objects.equals(promotionId, that.promotionId) && Objects.equals(attributId61, that.attributId61) && Objects.equals(customAttribute60, that.customAttribute60) && Objects.equals(creationDateSfcc, that.creationDateSfcc) && Objects.equals(paymentType, that.paymentType) && Objects.equals(idCallCenter, that.idCallCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, total, status, confirmationStatus, createdBy, creationDate, customerName, customerPhone, customerEmail, customerId, customerNo, lastModified, paymentOrderStatus, paymentStatus, shippingStatus, siteId, paymentAmount, shipmentType, shipmentCity, shipmentState, shipmentAddress, shipmentAddress2, shipmentMethodId, shippingTotal, productTotal, productQuantity, statusRayo, statusFlujo, shipmentDeliveryMessage, createdAt, updatedAt, local, customerCi, shippingTotalTax, totalTax, statusInvoice, statusPick, companyId, startPickingDate, endPickingDate, creationDateTimePda, rejectedReason, rejectedVendorId, rejectedDate, uen, hasPrescription, carrier, logged, localPick, statusOms, omsRetry, exportStatus, folioNo, isValidFolio, canalVenta, idCallCenterTiendaBase, idCallCenterPedido, folioPedidoPospcCallCenter, horaSalida, horaRegreso, statusPospc, folioPospc, tiempoOperativo, freeShippingPromotionId, freeShippingCampaignId, promotionId, attributId61, customAttribute60, creationDateSfcc, paymentType, idCallCenter);
    }
}
