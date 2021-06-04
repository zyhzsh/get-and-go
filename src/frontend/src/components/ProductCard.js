import React from "react";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Typography from "@material-ui/core/Typography";
import CardActions from '@material-ui/core/CardActions';
import {Button} from "antd";
import styled from "styled-components";

const ProductCard=({product,openDetail}) =>{

const TrimDownStringTo = (text,from,to)=>{
  let result;
  try{
    result=text.substring(from,to);
  }
  catch(e){
    return;
  }
  return result;
}
  return (
    <CardContainer onClick={()=>{openDetail(product)}}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Contemplative Reptile"
          height="200"
          image={product.img}
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography gutterBottom variant="h6" component="h2">
            {TrimDownStringTo(product.product_name,0,18)+"..."}
          </Typography>
          <Typography gutterBottom variant="" component="p">
            {"Provider: "+TrimDownStringTo(product.store.store_name,0,18)}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Price: {product.price} €<br/>
          </Typography>
          <Typography variant="body3" color="textSecondary" component="p">
          {TrimDownStringTo(product.description,0,30)+"\n"+TrimDownStringTo(product.description,30,55)+"..."}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button color="primary" onClick={()=>{openDetail(product)}}>
          Learn More
        </Button>
      </CardActions>
    </CardContainer>
  );
}
const CardContainer=styled(Card)`
    max-width:250px;
    margin-left:0.5rem;
    margin-top:1rem;
    display:block;
    height:420px;
`;
export default ProductCard;
