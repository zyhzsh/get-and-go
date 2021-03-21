import React from "react";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Typography from "@material-ui/core/Typography";
import styled from "styled-components";

const ProductCard=({product}) =>{
  return (
    <CardContainer>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Contemplative Reptile"
          height="140"
          image={product.img}
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            {product.product_name}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Price: €{product.price}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
           {product.description}
          </Typography>
        </CardContent>
      </CardActionArea>
    </CardContainer>
  );
}
const CardContainer=styled(Card)`
    max-width:240px;
    margin-left:0.5rem;
    margin-top:1rem;
    display:block;
    height:300px;
`;

export default ProductCard;
