/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package com.airport.mgmt.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;


// ----------- << imports@AAAAAAF2pLePB8kMgsI= >>
// ----------- >>

@Entity
@Getter
@Setter
@NoArgsConstructor
// ----------- << class.annotations@AAAAAAF2pLePB8kMgsI= >>
// ----------- >>
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // ----------- << id.annotations@AAAAAAF2pLePB8kMgsI= >>
    // ----------- >>
    private Long id;

    @Version
    // ----------- << version.annotations@AAAAAAF2pLePB8kMgsI= >>
    // ----------- >>
    private Long version;

    @NotNull
    @Column(nullable = false)
    // ----------- << attribute.annotations@AAAAAAF2pLm808ovh1M= >>
    // ----------- >>
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "gate_id")
    // ----------- << attribute.annotations@AAAAAAF2pLzKncq7qEk= >>
    // ----------- >>
    private Gate gate;

    // ----------- << getId.annotations@AAAAAAF2pLePB8kMgsI= >>
    // ----------- >>
    public Long getId(){
        return id;
    }

    public Flight linkGate(Gate _gate) {
        if (_gate != null) {
            _gate.getFlights().add(this);
        }

        unlinkGate();
        setGate(_gate);
        return this;
    }

    public Flight unlinkGate() {
        if (getGate() != null) {
            getGate().getFlights().remove(this);
            setGate(null);
        }
        return this;
    }

    // ----------- << equals.annotations@AAAAAAF2pLePB8kMgsI= >>
    // ----------- >>
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (getId() == null) return false;
        return obj instanceof Flight && (getId().equals(((Flight) obj).getId()));
    }

    // ----------- << hashCode.annotations@AAAAAAF2pLePB8kMgsI= >>
    // ----------- >>
    @Override
    public int hashCode() {
        return 295;
    }

// ----------- << class.extras@AAAAAAF2pLePB8kMgsI= >>
    public boolean isAssignedToGate(){
        return getGate() != null;
    }
// ----------- >>
}