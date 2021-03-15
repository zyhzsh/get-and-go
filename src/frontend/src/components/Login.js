import React, { useState } from "react";
import styled from "styled-components";
import { userLogin } from "../actions/userAction";
import { useDispatch } from "react-redux";

const Login = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const dispatch = useDispatch();
  const handlelogin = (e) => {
    e.preventDefault();
    dispatch(
      userLogin({
        username: name,
        email: email,
        password: password,
      })
    );
  };
  return (
    <div>
      <form className="login__form" onSubmit={(e) => handlelogin(e)}>
        <h1>Login Here</h1>
        <input
          type="name"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
