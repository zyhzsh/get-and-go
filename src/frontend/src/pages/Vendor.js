import React from 'react';
import { Redirect } from "react-router";
import {useSelector } from "react-redux";
function Vendor() {
    // const Role = useSelector((state) => state.user);
    // if(Role.usertype!=="CUSTOMERUSER"){return <Redirect to= "/error"/>}
    return (
        <div>
            Vendor Page
        </div>
    )
};

export default Vendor;
