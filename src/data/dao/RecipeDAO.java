package data.dao;


import data.DALException;
import data.dto.IngredientBatchDTO;
import data.dto.RecipeDTO;
import data.idao.IRecipeDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeDAO extends StorageDAO implements IRecipeDAO {

    private static RecipeDAO instance = new RecipeDAO();

    private RecipeDAO() {
        try {
            Map<Integer,RecipeDTO> recipes = (Map<Integer, RecipeDTO>) super.load();
        } catch (ClassNotFoundException | IOException e) {
            super.save(new HashMap<Integer, RecipeDTO>());
        }
    }

    public static RecipeDAO getInstance()
    {
        return instance;
    }

    @Override
    public RecipeDTO getRecipe(int RecipeId) throws DALException {
        try {
            Map<Integer,RecipeDTO> recipes = (HashMap<Integer, RecipeDTO>) super.load();
            if (recipes.containsKey(RecipeId))
                return recipes.get(RecipeId);
            else
                throw new DALException("Recipe with this ID does not exist.");
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RecipeDTO> getRecipeList() {
        try {
            Map<Integer, RecipeDTO> recipes = (HashMap<Integer, RecipeDTO>) super.load();
            return new ArrayList<>(recipes.values());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createRecipe(RecipeDTO recipe) throws DALException {
        try {
            Map<Integer, RecipeDTO> recipes = (HashMap<Integer, RecipeDTO>) super.load();
            if (!recipes.containsKey(recipe.getRecipeId())) {
                recipes.put(recipe.getRecipeId(),recipe);
                super.save(recipes);
            } else
                throw new DALException("Recipe with this ID already exists.");
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateRecipe(RecipeDTO recipe) {
        try {
            Map<Integer, RecipeDTO> recipes = (HashMap<Integer, RecipeDTO>) super.load();
            recipes.replace(recipe.getRecipeId(), recipe);
            super.save(recipes);
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}