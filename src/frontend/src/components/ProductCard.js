import React from "react";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Typography from "@material-ui/core/Typography";
import styled from "styled-components";

const ProductCard=({product,toggleOpenDetail}) =>{


  return (
    <CardContainer onClick={()=>{toggleOpenDetail(product)}}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Contemplative Reptile"
          height="150"
          image={product.img}
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography gutterBottom variant="h6" component="h2">
            {product.product_name}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Price: €{product.price}<br/>
            {product.description }
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
          </Typography>
        </CardContent>
      </CardActionArea>
    </CardContainer>
  );
}
const CardContainer=styled(Card)`
    max-width:250px;
    margin-left:0.5rem;
    margin-top:1rem;
    display:block;
    height:350px;
`;

export default ProductCard;
